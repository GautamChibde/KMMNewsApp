package com.example.newsapp.interactor

import com.example.newsapp.api.SearchApi
import com.example.newsapp.api.buildUrl
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsApiResponse
import io.ktor.client.*
import io.ktor.client.request.*

class SearchIntaractor(val httpClient: HttpClient) : SearchApi {
    override suspend fun searchResults(query: String): DataState<SearchResults> {
        try {
            val results = httpClient.get<NewsApiResponse>() {
                buildUrl(
                    path = "v2/everything",
                    parameters = listOf(
                        Pair("q", query)
                    )
                )
            }

            if (results.totalResults == 0) return DataState.Empty
            return DataState.Success(SearchResults(results.articles))
        } catch (e: Exception) {
            return DataState.Error(e.toString())
        }
    }
}