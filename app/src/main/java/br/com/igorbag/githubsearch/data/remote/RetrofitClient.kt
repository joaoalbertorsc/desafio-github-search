package br.com.igorbag.githubsearch.data.remote

import br.com.igorbag.githubsearch.data.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"

    val githubService: GitHubService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }
}
