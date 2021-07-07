package com.example.newsapp.interactor

import com.example.newsapp.api.NewsApi
import com.example.newsapp.api.buildUrl
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsApiResponse
import io.ktor.client.*
import io.ktor.client.request.*

class FeedsIntaractor(private val httpClient: HttpClient) : NewsApi {

    override suspend fun fetchHomePageResults(): DataState<HomePageResults> {
        try {
            val topHeadLinesResponse = httpClient.get<NewsApiResponse>() {
                buildUrl(
                    path = "v2/top-headlines",
                    listOf(
                        Pair("country", "us"),
                        Pair("pageSize", "11")
                    )
                )
            }
            if (topHeadLinesResponse.totalResults == 0) {
                return DataState.Empty
            }
            val results = HomePageResults(
                topNews = topHeadLinesResponse.articles.firstOrNull(),
                articles = topHeadLinesResponse.articles.subList(
                    1,
                    topHeadLinesResponse.articles.size
                )
            )
            return DataState.Success(results)
        } catch (e: Exception) {
            return DataState.Error(e.toString())
        }
    }
}