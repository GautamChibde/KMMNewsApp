package com.example.newsapp.android.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.model.Article
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Preview
@Composable
fun Search() {
    Column() {
        DiscoverComponent()
        TabBarNewsCategories(listOf("Health", "Politics", "Art", "Food", "Technology"))
    }
}

@Composable
fun DiscoverComponent() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Discover", style = NewsAppTypography.h4)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "News from all over the world", style = NewsAppTypography.subtitle1)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Search") })
    }
}

@ExperimentalPagerApi
@Composable
fun TabBarNewsCategories(newsCategories: List<String>) {
    val pagerState = rememberPagerState(pageCount = newsCategories.size)
    ScrollableTabRow(selectedTabIndex = pagerState.currentPage, backgroundColor = Color.White) {
        newsCategories.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                },
                text = { Text(text = item) }
            )
        }
    }
    HorizontalPager(state = pagerState) { page ->
        NewsCategoryList(articles = Article.dummyData)
    }
}

@Composable
fun NewsCategoryList(articles: List<Article>) {
    LazyColumn {
        items(articles) { item ->
            NewsCategoryListItem(item)
        }
    }
}

@Composable
fun NewsCategoryListItem(article: Article) {
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
                Text(text = "4 hours ago", style = NewsAppTypography.subtitle2)
                Spacer(Modifier.weight(1f))
                Text(
                    text = "376 views",
                    style = NewsAppTypography.subtitle2.copy(color = Color.LightGray)
                )
            }
        }
    }
}