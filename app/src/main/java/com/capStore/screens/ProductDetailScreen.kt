package com.capStore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.capStore.model.Product
import com.capStore.model.ProductData
import com.capStore.R



@Composable
fun DetailBottomNavigationBar(
    navController: NavHostController,
    productId: String,
    onAddToCart: () -> Unit
) {

    val product = ProductData.products.find{ it.id == productId.toInt() }

    if (product == null) {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) }
        ) { padding ->
            Text(
                text = "Oops! Product not found",
                modifier = Modifier.padding(padding).padding(16.dp)
            )
        }
        return
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.cap_det),
                fontSize = 22.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center

            )
            Spacer(Modifier.height(10.dp))

            Image(
                painter = painterResource(id=product.imageRes!!),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().size(400.dp),
                alignment = Alignment.Center,
            )
            Text(
                product.name!!,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,

            )
            Spacer(Modifier.height(20.dp))

            Text("This timeless baseball cap offers a comfortable fit and stylish look. " +
                    "Made from durable cotton, it's perfect for everyday wear.")

            Spacer(Modifier.height(10.dp))
            Text(
                text="Details",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Material", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text("Cotton", style = MaterialTheme.typography.bodySmall)
                        }
                    Column {
                        Text("Size", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text("Adjustable", style = MaterialTheme.typography.bodySmall)
                        }

                    Column {
                        Text("Care", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text("Hand wash", style = MaterialTheme.typography.bodySmall)
                        }
                    }
            }

            Button(
                onClick = onAddToCart,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4A90E2)
                )

            ) {
                Text("Add to cart")
            }
        }
    }
}
