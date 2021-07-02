package com.example.newsapp.android

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.newsapp.android.ui.HomeSections
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.android.ui.addHomeGraph
import com.google.accompanist.pager.ExperimentalPagerApi


object MainDestinations {
    const val HOME_ROUTE = "home"
    const val LATEST_NEWS = "LATEST_NEWS"
    const val SEARCH = "SEARCH"
}

@ExperimentalPagerApi
@Composable
fun NewsAppNavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.HOME_ROUTE,
    homeViewModel: HomeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = MainDestinations.HOME_ROUTE,
            startDestination = HomeSections.FEED.route
        ) {
            addHomeGraph(homeViewModel)
        }
    }
}