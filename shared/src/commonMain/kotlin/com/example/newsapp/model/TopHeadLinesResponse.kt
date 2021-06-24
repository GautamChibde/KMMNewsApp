package com.example.newsapp.model

data class TopHeadLinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)