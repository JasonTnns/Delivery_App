package com.example.deliveryapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deliveryapp.ui.screens.CartScreen
import com.example.deliveryapp.ui.screens.HomeScreen
import com.example.deliveryapp.ui.screens.MenuScreen

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onRestaurantClick = { restaurantId ->
                    navController.navigate("menu/$restaurantId")
                }
            )
        }
        composable("menu/{restaurantId}") { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")
            MenuScreen(restaurantId = restaurantId,
                onCartClick = {navController.navigate("cart")})
        }
        composable("cart") {
            CartScreen()
        }
    }
}