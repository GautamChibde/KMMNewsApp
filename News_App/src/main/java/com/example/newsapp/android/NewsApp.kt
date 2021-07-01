package com.example.newsapp.android

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.android.theme.NewsAppTheme
import com.example.newsapp.android.ui.BottomBar
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun NewsApp() {
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
                scaffoldState = scaffoldState
            )
        }

    }
}