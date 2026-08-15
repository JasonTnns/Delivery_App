package com.example.deliveryapp

data class MenuItem(
    val id: Int,
    val restaurantId: Int,
    val name: String,
    val price: Double,
    val imageUrl: String
)