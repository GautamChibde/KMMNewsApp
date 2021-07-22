package com.example.newsapp.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.android.ui.feed.FeedsPage
import com.example.newsapp.android.ui.profile.CategoryScreen
import com.example.newsapp.android.ui.profile.CategoryViewModel
import com.example.newsapp.android.ui.profile.Explore
import com.example.newsapp.android.ui.search.Search
import com.example.newsapp.model.NewsCategories
import com.google.accompanist.pager.ExperimentalPagerApi

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val LATEST_NEWS = "latest_news"
    const val SEARCH = "search"
    const val NEWS_CATEGORY = "news_category/{category}"
}

enum class HomeSections(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    FEED("Feed", Icons.Outlined.Home, "home/feed"),
    SEARCH("Search", Icons.Outlined.Search, "home/search"),
    PROFILE("Explore", Icons.Outlined.Explore, "home/explore")
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NewsAppNavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.HOME_ROUTE,
    homeViewModel: HomeViewModel,
    categoryViewModel: CategoryViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = MainDestinations.HOME_ROUTE,
            startDestination = HomeSections.FEED.route
        ) {
            composable(HomeSections.FEED.route) {
                FeedsPage(homeViewModel)
            }
            composable(HomeSections.SEARCH.route) {
                Search(homeViewModel)
            }
            composable(HomeSections.PROFILE.route) {
                Explore(navController)
            }
            composable(
                MainDestinations.NEWS_CATEGORY,
                arguments = listOf(navArgument("category") {})
            ) { bs ->
                CategoryScreen(
                    category = bs.arguments?.getString("category")?.let { NewsCategories.from(it) }
                        ?: NewsCategories.Business,
                    navController = navController,
                    viewModel = categoryViewModel
                )
            }
        }
    }
}