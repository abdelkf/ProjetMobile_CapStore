package com.capStore.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen(onPurchase: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Panier", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Total : 1200 DH")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onPurchase, modifier = Modifier.fillMaxWidth()) {
            Text("Valider l'achat")
        }
    }
}
