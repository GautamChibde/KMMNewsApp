package com.example.newsapp.android.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.android.ui.feed.FullScreenCenterComposable
import com.example.newsapp.android.ui.search.ArticleList
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsCategories

@Composable
fun CategoryScreen(
    category: NewsCategories,
    viewModel: CategoryViewModel,
    navController: NavHostController
) {
    viewModel.fetchCategoryList(category = category)
    val state = viewModel.articles.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(category.value, style = NewsAppTypography.subtitle2) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }
    ) {
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
                ArticleList(articles = results)
            }
        }
    }
}