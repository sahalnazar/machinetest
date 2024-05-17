package com.sahalnazar.swiggymachinetest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sahalnazar.swiggymachinetest.presentation.screen.detail.DetailScreen
import com.sahalnazar.swiggymachinetest.presentation.screen.home.HomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route) {
        composable(AppScreens.Home.route) {
            HomeScreen(navController, hiltViewModel())
        }
        composable(
            AppScreens.Detail.route + "/" + "movieId",
            listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                navController,
                hiltViewModel(),
                movieId = backStackEntry.arguments?.getString("userId")
            )
        }
    }

}

sealed class AppScreens(val route: String) {
    object Home : AppScreens("home")
    object Detail : AppScreens("detail")
}