package com.example.newsapp.api

import com.example.newsapp.interactor.HomePageResults

interface NewsApi {
    suspend fun fetchHomePageResults() : HomePageResults
}