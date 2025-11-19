package com.capStore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailScreen(productId: String, onAddToCart: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Détails du produit : $productId", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Description détaillée du produit...")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onAddToCart, modifier = Modifier.fillMaxWidth()) {
            Text("Ajouter au panier")
        }
    }
}
