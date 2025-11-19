package com.capStore.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PurchaseConfirmationScreen(onHome: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Achat réussi 🎉", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onHome) {
            Text("Retour à l'accueil")
        }
    }
}
