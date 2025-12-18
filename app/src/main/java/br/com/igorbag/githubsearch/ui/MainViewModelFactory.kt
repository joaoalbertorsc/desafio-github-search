package br.com.igorbag.githubsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.igorbag.githubsearch.data.GithubRepository

class MainViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
