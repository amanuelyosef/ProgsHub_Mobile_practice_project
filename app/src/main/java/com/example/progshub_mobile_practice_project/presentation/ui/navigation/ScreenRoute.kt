package com.example.progshub_mobile_practice_project.presentation.ui.navigation

sealed class ScreenRoute(val route:String) {
    data object HomeScreen : ScreenRoute("home_screen")
    data object ProductDetailsScreen : ScreenRoute("product_details_screen")
    data object CartScreen : ScreenRoute("cart_screen")
    data object FavoritesScreen : ScreenRoute("favorites_screen")
}