package com.example.newsapp.android.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newsapp.android.ui.feed.Feed
import com.example.newsapp.android.ui.home.Profile
import com.example.newsapp.android.ui.home.Search


fun NavGraphBuilder.addHomeGraph() {
    composable(HomeSections.FEED.route) { from ->
        Feed()
    }
    composable(HomeSections.SEARCH.route) { from ->
        Search()
    }
    composable(HomeSections.PROFILE.route) {
        Profile()
    }
}

enum class HomeSections(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    FEED("Feed", Icons.Outlined.Home, "home/feed"),
    SEARCH("Search", Icons.Outlined.Search, "home/search"),
    PROFILE("Profile", Icons.Outlined.AccountCircle, "home/profile")
}


@Composable
fun BottomBar(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val currentDestination = navBackStackEntry?.destination

        val sections = remember { HomeSections.values() }
        val routes = remember { sections.map { it.route } }

        sections.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route)
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = screen.title) },
            )
        }
    }
}