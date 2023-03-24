package com.github.jesushzc.todoapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.jesushzc.todoapplication.ui.home.Home
import com.github.jesushzc.todoapplication.utils.NavigationScreens.HOME_SCREEN

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        composable(
            route = HOME_SCREEN
        ) {
            Home()
        }
    }
}