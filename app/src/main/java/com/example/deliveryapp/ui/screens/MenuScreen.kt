package com.example.deliveryapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MenuScreen(restaurantId: String?) {
    Text(text = "Menu for restaurants #$restaurantId")
}