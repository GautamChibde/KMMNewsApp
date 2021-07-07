package com.example.newsapp.api

import com.example.newsapp.interactor.SearchResults
import com.example.newsapp.model.DataState

interface SearchApi {
    suspend fun searchResults(query: String): DataState<SearchResults>
}