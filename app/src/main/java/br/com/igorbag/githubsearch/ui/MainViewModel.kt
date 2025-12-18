package br.com.igorbag.githubsearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.igorbag.githubsearch.data.GithubRepository
import br.com.igorbag.githubsearch.domain.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val githubRepository: GithubRepository) : ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> = _repositories

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getAllReposByUserName(userName: String) {
        _loading.value = true
        githubRepository.getAllRepositoriesByUser(userName).enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                _loading.value = false
                if (response.isSuccessful) {
                    _repositories.value = response.body()
                } else {
                    _error.value = true
                }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                _loading.value = false
                _error.value = true
            }
        })
    }
}
