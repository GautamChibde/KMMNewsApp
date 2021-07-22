package com.example.newsapp.android.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.model.Article
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ArticleList(articles: List<Article>) {
    LazyColumn {
        items(articles) { item ->
            ArticleListItem(item)
        }
    }
}

@Composable
fun ArticleListItem(article: Article) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberCoilPainter(request = article.urlToImage),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = article.title, style = NewsAppTypography.subtitle1, maxLines = 3)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(text = article.publishedAt, style = NewsAppTypography.subtitle2)
                Spacer(Modifier.weight(1f))
                Text(
                    text = "376 views",
                    style = NewsAppTypography.subtitle2.copy(color = Color.LightGray)
                )
            }
        }
    }
}