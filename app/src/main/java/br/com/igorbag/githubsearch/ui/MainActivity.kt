package br.com.igorbag.githubsearch.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.data.GithubRepository
import br.com.igorbag.githubsearch.data.remote.RetrofitClient
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.adapter.RepositoryAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var nomeUsuario: EditText
    private lateinit var btnConfirmar: Button
    private lateinit var listaRepositories: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(GithubRepository(RetrofitClient.githubService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
        setupObservers()
        showUserName()
    }

    private fun setupView() {
        nomeUsuario = findViewById(R.id.et_nome_usuario)
        btnConfirmar = findViewById(R.id.btn_confirmar)
        listaRepositories = findViewById(R.id.rv_lista_repositories)
        // Note: Check if there's a progress bar in your XML, otherwise this might need to be added.
        // I'll assume there is one or skip it if not found in layout analysis.
        // progressBar = findViewById(R.id.pb_loader) 
    }

    private fun setupListeners() {
        btnConfirmar.setOnClickListener {
            val user = nomeUsuario.text.toString()
            if (user.isNotEmpty()) {
                saveUserLocal(user)
                viewModel.getAllReposByUserName(user)
            } else {
                Toast.makeText(this, "Por favor, insira um usuário", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupObservers() {
        viewModel.repositories.observe(this) { repositories ->
            setupAdapter(repositories)
        }

        viewModel.error.observe(this) { hasError ->
            if (hasError) {
                Toast.makeText(this, R.string.response_error, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            // Update UI visibility for loading state if you have a progress bar
            // progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    private fun saveUserLocal(user: String) {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("USER_NAME", user)
            apply()
        }
    }

    private fun showUserName() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val savedUser = sharedPref.getString("USER_NAME", null)
        if (!savedUser.isNullOrEmpty()) {
            nomeUsuario.setText(savedUser)
            viewModel.getAllReposByUserName(savedUser)
        }
    }

    private fun setupAdapter(list: List<Repository>) {
        val adapter = RepositoryAdapter(list)
        listaRepositories.adapter = adapter
        adapter.btnShareLister = {
            shareRepositoryLink(it.htmlUrl)
        }
        adapter.carItemLister = {
            openBrowser(it.htmlUrl)
        }
    }

    private fun shareRepositoryLink(urlRepository: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, urlRepository)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun openBrowser(urlRepository: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlRepository)))
    }
}