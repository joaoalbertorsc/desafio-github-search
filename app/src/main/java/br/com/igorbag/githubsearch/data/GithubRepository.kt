package br.com.igorbag.githubsearch.data

import br.com.igorbag.githubsearch.domain.Repository
import retrofit2.Call

class GithubRepository(private val githubService: GitHubService) {

    fun getAllRepositoriesByUser(user: String): Call<List<Repository>> {
        return githubService.getAllRepositoriesByUser(user)
    }

}
