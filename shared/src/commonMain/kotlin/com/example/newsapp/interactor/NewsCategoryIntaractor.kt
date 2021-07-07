package com.example.newsapp.interactor

import com.example.newsapp.api.NewsCategoryApi
import com.example.newsapp.api.buildUrl
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsApiResponse
import com.example.newsapp.model.NewsCategories
import io.ktor.client.*
import io.ktor.client.request.*

class NewsCategoryIntaractor(val httpClient: HttpClient) : NewsCategoryApi {
    override suspend fun fetchArticlesByCategory(category: NewsCategories): DataState<List<Article>> {
        return try {
            val results = httpClient.get<NewsApiResponse>() {
                buildUrl(
                    path = "v2/top-headlines",
                    parameters = listOf(
                        Pair("category", category.value)
                    )
                )
            }
            if (results.totalResults == 0) DataState.Empty
            DataState.Success(results.articles)
        } catch (e: Exception) {
            DataState.Error(e.toString())
        }
    }
}