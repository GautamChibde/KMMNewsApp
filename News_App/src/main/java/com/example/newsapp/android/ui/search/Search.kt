package com.example.newsapp.android.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.android.ui.feed.FullScreenCenterComposable
import com.example.newsapp.interactor.SearchResults
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun Search(viewModel: HomeViewModel) {
    Column {
        val state = viewModel.searchResults.observeAsState()
        DiscoverComponent() { query ->
            viewModel.searchNewsArticles(query = query)
        }

        when (state.value) {
            DataState.Empty -> {

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
            DataState.Loading -> {
                FullScreenCenterComposable {
                    CircularProgressIndicator()
                }
            }
            is DataState.Success -> {
                val results = (state.value as DataState.Success<SearchResults>).data
                NewsCategoryList(articles = results.articles)
            }
        }
    }
}

@Composable
fun DiscoverComponent(searchResults: (String) -> Unit) {
    var query by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
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
        Row(
            modifier = Modifier.height(55.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                value = query,
                onValueChange = { query = it },
                label = { Text(text = "Search") })
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier.fillMaxHeight(),
                onClick = {
                    searchResults(query)
                    focusManager.clearFocus()
                }) {
                Text(
                    text = "Go",
                )
            }
        }
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