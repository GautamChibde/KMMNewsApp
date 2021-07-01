package com.example.newsapp.api

import com.example.newsapp.model.TopHeadLinesResponse

interface NewsApi {
    suspend fun getTopHeadLines() : TopHeadLinesResponse
}