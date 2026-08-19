package com.example.deliveryapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deliveryapp.CartManager
import com.example.deliveryapp.MenuViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
@Composable
fun MenuScreen(
    restaurantId: String?,
    onCartClick: () -> Unit,
    viewModel: MenuViewModel = koinViewModel(),
    cartManager: CartManager = koinInject()
) {
    val filteredItems = viewModel.getItemsForRestaurant(restaurantId)

    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredItems) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { cartManager.addItem(item) }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = item.name)
                        Text(text = "$${item.price}")
                    }
                }
            }
        }
        Button(
            onClick = onCartClick,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("View Cart")
        }
    }
}