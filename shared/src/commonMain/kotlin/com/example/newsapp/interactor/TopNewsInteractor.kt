package com.example.newsapp.interactor

import com.example.newsapp.api.NewsAppHttpClient
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.coroutineContext

interface TopNewsResults {
    fun onResults()
    fun onError()
    fun onEmpty()
}

class TopNewsInteractor(results: TopNewsResults) {

    fun fetchTopNews() {
        val httpClient = NewsAppHttpClient()

    }

}