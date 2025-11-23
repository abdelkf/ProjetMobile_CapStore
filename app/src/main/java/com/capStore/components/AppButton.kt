package com.capStore.components

import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val currentRoute = navController.currentDestination?.route

    NavigationBar(containerColor = Color.White) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute == "products",
            onClick = { navController.navigate("products") },
            icon = { Icon(Icons.Default.List, contentDescription = "Products") },
            label = { Text("Products") }
        )

        NavigationBarItem(
            selected = currentRoute == "cart",
            onClick = { navController.navigate("cart") },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") }
        )

        NavigationBarItem(
            selected = currentRoute == "account",
            onClick = { navController.navigate("account") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Account") },
            label = { Text("Account") }
        )
    }

}