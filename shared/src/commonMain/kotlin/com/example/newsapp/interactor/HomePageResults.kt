package com.example.newsapp.interactor

import com.example.newsapp.model.Article

data class HomePageResults(
    val topNews: Article?,
    val articles: List<Article>
)