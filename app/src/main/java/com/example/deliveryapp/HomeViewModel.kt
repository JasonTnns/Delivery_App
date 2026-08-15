package com.example.deliveryapp

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel: ViewModel() {
    val restaurants = listOf(
        Restaurant(1, "Burger Zone", "Burgers", ""),
        Restaurant(2, "123 Pasta", "Pasta", ""),
        Restaurant(3, "Amar", "Lebanese", ""),
        Restaurant(4, "Sushi Star", "Japanese", "")
    )
}