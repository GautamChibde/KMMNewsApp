package com.example.newsapp.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.android.theme.NewsAppTheme
import com.example.newsapp.android.ui.BottomBar
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.android.ui.profile.CategoryViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NewsApp(viewModel: HomeViewModel, categoryViewModel: CategoryViewModel) {
    NewsAppTheme {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomBar(navController = navController)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NewsAppNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    homeViewModel = viewModel,
                    categoryViewModel = categoryViewModel
                )
            }
        }
    }
}