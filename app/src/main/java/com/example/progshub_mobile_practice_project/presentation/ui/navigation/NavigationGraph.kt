package com.example.progshub_mobile_practice_project.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.progshub_mobile_practice_project.presentation.ui.screens.CartScreen
import com.example.progshub_mobile_practice_project.presentation.ui.screens.FavoritesScreen
import com.example.progshub_mobile_practice_project.presentation.ui.screens.ProductDetailsScreen
import com.example.progshub_mobile_practice_project.presentation.ui.screens.ProductListingScreen

@Composable
fun NavigationGraph() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeScreen.route
    ) {

        composable(ScreenRoute.HomeScreen.route) {
            ProductListingScreen(
                navController = navController
            )
        }

        composable(ScreenRoute.CartScreen.route) {
            CartScreen(
                navController = navController
            )
        }

        composable(ScreenRoute.FavoritesScreen.route) {
            FavoritesScreen(
                navController = navController
            )
        }

        composable(ScreenRoute.ProductDetailsScreen.route) {
            ProductDetailsScreen(
                navController = navController
            )
        }
    }
}