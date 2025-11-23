package com.capStore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.capStore.model.Product
import com.capStore.model.ProductData
import com.capStore.util.ProductCollection

@Composable
fun ProductListScreen(navController: NavHostController,
                      onProductClick: (Int) -> Unit) {

    var selectedFilter by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }

    val productCollection = ProductCollection(ProductData.products)
    val iterator = productCollection.createIterator()

    val products = buildList {
        while (iterator.hasNext()) {
            add(iterator.next())
        }
    }

    val filteredProducts = products.filter { product ->
        (selectedFilter == "All" || product.label == selectedFilter) &&
                (product.name?.contains(searchQuery, ignoreCase = true) == true)
    }


    Scaffold(
        topBar = {
            ProductListHeader(
                selectedFilter = selectedFilter,
                onFilterChange = { selectedFilter = it },
                searchQuery = searchQuery,
                onSearch = { searchQuery = it }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(filteredProducts) { product ->
                ProductItem(product,onProductClick)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}


@Composable
fun ProductListHeader(
    selectedFilter: String,
    onFilterChange: (String) -> Unit,
    searchQuery: String,
    onSearch: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Products",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearch,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search products...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Filters
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf("All", "New", "Sale").forEach { filter ->
                FilterChip(
                    selected = selectedFilter == filter,
                    onClick = { onFilterChange(filter) },
                    label = { Text(filter) }
                )
            }
        }
    }
}


@Composable
fun ProductItem(product: Product, onProductClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onProductClick(product.id) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),

    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product Texts
          Column(modifier = Modifier.weight(1.2f)) {
                if (!product.label.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.height(6.dp))
                    LabelChip(product.label)
                }

                Text(
                    product.name?:"Unknown name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    "$${product.price?:0.0}",
                    color = Color(0xFF4A90E2)
                )


            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(product.imageRes!!),
                contentDescription = product.name,
                alignment = Alignment.CenterEnd,
                modifier = Modifier.size(80.dp)

            )

            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar(containerColor = Color.White) {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = true,  // tu es sur Products
            onClick = { navController.navigate("products") },
            icon = { Icon(Icons.Default.List, contentDescription = "Products") },
            label = { Text("Products") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("cart") },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("account") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Account") },
            label = { Text("Account") }
        )
    }
}


@Composable
fun LabelChip(text: String) {
    Box(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text, color = Color.DarkGray, fontSize = 12.sp)
    }
}