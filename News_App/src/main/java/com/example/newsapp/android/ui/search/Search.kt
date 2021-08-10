package com.example.newsapp.android.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.android.ui.feed.FullScreenCenterComposable
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState

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
                val results = (state.value as DataState.Success<List<Article>>).data
                ArticleList(articles = results) {

                }
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