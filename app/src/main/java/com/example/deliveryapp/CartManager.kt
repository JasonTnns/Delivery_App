package com.example.deliveryapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import org.koin.core.annotation.Single

@Single
class CartManager {
    val items = mutableStateListOf<CartItem>()

    fun addItem(menuItem: MenuItem) {
        val existing = items.find { it.menuItem.id == menuItem.id }
        if(existing != null) {
            val index = items.indexOf(existing)
            items[index] = existing.copy(quantity = existing.quantity + 1)
        }
        else {
            items.add(CartItem(menuItem, 1))
        }
    }
    fun totalPrice(): Double {
        return items.sumOf { it.menuItem.price * it.quantity }
    }
}