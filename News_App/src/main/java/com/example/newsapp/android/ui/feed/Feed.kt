package com.example.newsapp.android.ui.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.newsapp.Article

@Composable
fun Feed() {
    Column() {
        TopAppBar(
            title = { Text(text = "AppBar") }
        )
        NewsOfTheDay(Article.dummyData.first())
        ComposablePreview(articles = Article.dummyData)
    }
}