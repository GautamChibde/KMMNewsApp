package com.example.newsapp.android.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.newsapp.Article
import com.example.newsapp.android.theme.NewsAppTypography
import com.google.accompanist.coil.rememberCoilPainter

class SampleArticleProvider : PreviewParameterProvider<Article> {
    override val values = sequenceOf(
        Article.dummyData.first()
    )
    override val count: Int = values.count()
}

@Composable
fun FeedsPage() {
    Column {
        TopNews(article = Article.dummyData.first())
        BreakingNewsItems(articles = Article.dummyData.subList(1, Article.dummyData.size))
    }
}

@Preview
@Composable
fun TopNews(@PreviewParameter(SampleArticleProvider::class) article: Article) {
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
                .matchParentSize()
                .padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.LightGray.copy(alpha = 0.5f))
                    .padding(8.dp)
            ) {
                Text(
                    text = "News of the day",
                    style = NewsAppTypography.subtitle1.copy(color = Color.White),
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.title, style = NewsAppTypography.h6.copy(color = Color.White))
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Learn More ->",
                style = NewsAppTypography.subtitle1.copy(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun BreakingNewsItems(@PreviewParameter(SampleArticleProvider::class) articles: List<Article>) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(text = "Breaking News", style = NewsAppTypography.subtitle1)
        Spacer(Modifier.weight(1f))
        Text(text = "More", style = NewsAppTypography.subtitle1)
    }

    LazyRow() {
        items(articles) { item ->
            BreakingNewsItem(article = item)
        }
    }

}

@Composable
fun BreakingNewsItem(@PreviewParameter(SampleArticleProvider::class) article: Article) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
            .width(240.dp)
    ) {
        Column {
            Image(
                painter = rememberCoilPainter(
                    request = article.urlToImage,
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.title, style = NewsAppTypography.subtitle1, maxLines = 3)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "4 hr ago", style = NewsAppTypography.caption.copy(color = Color.Gray))
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "By ${article.author}",
                style = NewsAppTypography.caption.copy(color = Color.Gray)
            )
        }
    }
}