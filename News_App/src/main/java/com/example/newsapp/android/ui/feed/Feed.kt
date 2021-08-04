package com.example.newsapp.android.ui.feed

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.interactor.HomePageResults
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.google.accompanist.coil.rememberCoilPainter

class SampleArticleListProvider : PreviewParameterProvider<List<Article>> {
    override val values = sequenceOf(
        Article.dummyData
    )
    override val count: Int = values.count()
}

class SampleArticleProvider : PreviewParameterProvider<Article> {
    override val values = sequenceOf(
        Article.dummyData.first()
    )
    override val count: Int = values.count()
}

@Composable
fun FeedsPage(viewModel: HomeViewModel, navController: NavHostController) {
    viewModel.getHomePageResults()
    val state = viewModel.topNewsResults.observeAsState(initial = DataState.Loading)
    when (state.value) {
        is DataState.Loading -> {
            FullScreenCenterComposable {
                CircularProgressIndicator()
            }
        }
        DataState.Empty -> {
            FullScreenCenterComposable {
                Text(text = "Nothing found at the moment")
            }
        }
        is DataState.Error -> {
            FullScreenCenterComposable {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Outlined.Error,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Something went wrong", style = NewsAppTypography.subtitle1)
                }
            }
        }
        is DataState.Success -> {
            val results = (state.value as DataState.Success<HomePageResults>).data
            Column {
                TopNews(article = results.topNews) { url ->
                    navController.currentBackStackEntry?.arguments = Bundle().apply {
                        putSerializable("url", url)
                    }
                    navController.navigate("article_detail")
                }
                BreakingNewsItems(articles = results.articles) { url ->
                    navController.currentBackStackEntry?.arguments = Bundle().apply {
                        putSerializable("url", url)
                    }
                    navController.navigate("article_detail")
                }
            }
        }
    }
}

@Composable
fun FullScreenCenterComposable(content: @Composable() () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}

@Composable
fun TopNews(
    @PreviewParameter(SampleArticleProvider::class) article: Article?,
    onItemClicked: (url: String) -> Unit
) {
    article?.let {
        Box(
            Modifier
                .height(340.dp)
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                .clickable { onItemClicked(article.url) }
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
                        .background(color = Color.Black.copy(alpha = 0.5f))
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
    } ?: run {
        Box {}
    }
}

@Composable
fun BreakingNewsItems(
    @PreviewParameter(SampleArticleListProvider::class) articles: List<Article>,
    onItemClicked: (url: String) -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(text = "Breaking News", style = NewsAppTypography.subtitle1)
        Spacer(Modifier.weight(1f))
        Text(text = "More", style = NewsAppTypography.subtitle1)
    }

    LazyRow {
        items(articles) { item ->
            BreakingNewsItem(article = item, onItemClicked)
        }
    }

}

@Composable
fun BreakingNewsItem(
    @PreviewParameter(SampleArticleProvider::class) article: Article,
    onItemClicked: (url: String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
            .width(240.dp)
            .clickable { onItemClicked(article.url) }
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
            Text(
                text = article.publishedAt,
                style = NewsAppTypography.caption.copy(color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "By ${article.author}",
                style = NewsAppTypography.caption.copy(color = Color.Gray)
            )
        }
    }
}