package com.example.deliveryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.CartManager
import org.koin.compose.koinInject

@Composable
fun CartScreen(cartManager: CartManager = koinInject()) {
    val cartItems = cartManager.items

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cartItems) { cartItem ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = "${cartItem.menuItem.name} x${cartItem.quantity}")
                        Text(text = "${cartItem.menuItem.price} * ${cartItem.quantity}")
                    }
                }
            }
        }
        Text(text = "Total: $${cartManager.totalPrice()}")
    }
}