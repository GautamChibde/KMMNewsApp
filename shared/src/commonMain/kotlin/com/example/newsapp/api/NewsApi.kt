package com.example.newsapp.api

import com.example.newsapp.interactor.HomePageResults
import com.example.newsapp.model.DataState

interface NewsApi {
    suspend fun fetchHomePageResults() : DataState<HomePageResults>
}