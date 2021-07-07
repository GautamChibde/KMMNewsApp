package com.example.newsapp.api

import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsCategories

interface NewsCategoryApi {
    suspend fun fetchArticlesByCategory(category: NewsCategories): DataState<List<Article>>
}