package com.example.newsapp.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.Article
import com.google.accompanist.coil.rememberCoilPainter

@Preview
@Composable
fun NewsOfTheDay(@PreviewParameter(SampleArticleProvider::class) article: Article) {
    Box(
        Modifier
            .height(340.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = rememberCoilPainter(request = article.urlToImage),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier.height(340.dp)
        )

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(top = 56.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = "News of the day", style = TextStyle(color = Color.White, fontSize = 14.sp))
            Text(text = article.title, style = TextStyle(color = Color.White, fontSize = 18.sp))
            Text(text = "Learn More ->", style = TextStyle(color = Color.Black, fontSize = 16.sp))
        }
    }
}