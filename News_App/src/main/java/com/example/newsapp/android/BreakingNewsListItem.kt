package com.example.newsapp.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.newsapp.Article
import com.google.accompanist.coil.rememberCoilPainter

class SampleArticleProvider : PreviewParameterProvider<Article> {
    override val values = sequenceOf(
        Article.dummyData.first()
    )
    override val count: Int = values.count()
}

@Preview
@Composable
fun breakingNewsListItem(@PreviewParameter(SampleArticleProvider::class) article: Article) {
    Column(Modifier.background(
        color = Color.White
    )) {
        Box(Modifier.height(100.dp)) {
            Image(
                painter = rememberCoilPainter(
                    request = article.urlToImage,
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
        Text(text = article.title, style = TextStyle(color = Color.Black))
        Text(text = "4 hr ago")
        Text(text = "By ${article.author}")
    }
}