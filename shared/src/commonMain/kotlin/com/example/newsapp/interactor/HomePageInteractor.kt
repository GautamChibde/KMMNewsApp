package com.example.newsapp.interactor

import com.example.newsapp.api.NewsApi
import com.example.newsapp.api.buildUrl
import com.example.newsapp.model.TopHeadLinesResponse
import io.ktor.client.*
import io.ktor.client.request.*

interface TopNewsResults {
    fun onResults()
    fun onError()
    fun onEmpty()
}

class HomePageInteractor(private val httpClient: HttpClient) : NewsApi {

    override suspend fun fetchHomePageResults(): HomePageResults {
        val topHeadLinesResponse = httpClient.get<TopHeadLinesResponse>() {
            buildUrl(
                path = "v2/top-headlines",
                listOf(
                    Pair("country", "us"),
                    Pair("pageSize", "11")
                )
            )
        }

        return HomePageResults(
            topNews = topHeadLinesResponse.articles.firstOrNull(),
            articles = topHeadLinesResponse.articles.subList(1, topHeadLinesResponse.articles.size)
        )
    }
}