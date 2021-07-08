package com.example.newsapp.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.android.theme.NewsAppTheme
import com.example.newsapp.android.ui.BottomBar
import com.example.newsapp.android.ui.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NewsApp(viewModel: HomeViewModel) {
    NewsAppTheme {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomBar(navController = navController)
            }
        ) {
            NewsAppNavGraph(
                navController = navController,
                scaffoldState = scaffoldState,
                homeViewModel = viewModel
            )
        }

    }
}