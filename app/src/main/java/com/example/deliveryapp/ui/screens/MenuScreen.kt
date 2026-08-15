package com.example.deliveryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.MenuItem

@Composable
fun MenuScreen(restaurantId: String?) {
    val allMenuItems = listOf(
        MenuItem(1, 1, "Classic Burger", 8.50, ""),
        MenuItem(2, 1, "Cheese Fries", 4.00, ""),
        MenuItem(3, 2, "Spaghetti Carbonara", 10.00, ""),
        MenuItem(4, 3, "Chicken Tawook", 9.00, ""),
        MenuItem(5, 4, "California roll", 7.50, "")
        )

    val filteredItems = allMenuItems.filter { it.restaurantId.toString() == restaurantId }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filteredItems) { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = item.name)
                    Text(text = "$${item.price}")
                }
            }
        }
    }
}