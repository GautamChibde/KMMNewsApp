package com.example.newsapp.api

import com.example.newsapp.model.Article

interface NewsApi {
    suspend fun getTopHeadLines() : List<Article>
}