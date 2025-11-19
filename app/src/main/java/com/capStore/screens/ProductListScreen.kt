package com.capStore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductListScreen(onProductClick: (String) -> Unit) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onProductClick("Produit$index") }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Produit $index", style = MaterialTheme.typography.titleLarge)
                    Text("Prix : ${(index + 1) * 100} DH")
                }
            }
        }
    }
}
