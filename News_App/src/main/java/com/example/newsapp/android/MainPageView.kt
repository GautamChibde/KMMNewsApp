package com.example.newsapp.android

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.newsapp.Article

@Preview
@Composable
fun ComposablePreview(@PreviewParameter(SampleArticleProvider::class) articles: List<Article>) {
    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        items(articles) { item ->
            breakingNewsListItem(article = item)
        }
    }
}

@Composable
fun SimpleComposable(greet: String) {
    Text("Hello World $greet")
}