package com.example.deliveryapp

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MenuViewModel: ViewModel() {
    private val allMenuItems = listOf(
        MenuItem(1, 1, "Classic Burger", 8.50, ""),
        MenuItem(2, 1, "Cheese Fries", 4.00, ""),
        MenuItem(3, 2, "Spaghetti Carbonara", 10.00, ""),
        MenuItem(4, 3, "Chicken Tawook", 9.00, ""),
        MenuItem(5, 4, "California Roll", 7.50, "")
    )

    fun getItemsForRestaurant(restaurantId: String?): List<MenuItem> {
        return allMenuItems.filter { it.restaurantId.toString() == restaurantId }
    }
}