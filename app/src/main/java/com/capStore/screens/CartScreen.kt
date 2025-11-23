package com.capStore.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.capStore.components.BottomNavigationBar
import com.capStore.R


@Composable
fun CartBottomNavigationBar(
    navController: NavHostController,
    onPurchase: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Cart",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            CartItemRow(
                name = "Classic Baseball Cap",
                price = 25,
                image = R.drawable.cap1
            )
            Spacer(Modifier.height(16.dp))

            CartItemRow(
                name = "Trucker Hat",
                price = 20,
                image = R.drawable.cap2
            )
            Spacer(Modifier.height(16.dp))

            CartItemRow(
                name = "Snapback Cap",
                price = 30,
                image = R.drawable.cap3
            )

            Spacer(Modifier.height(25.dp))

            SummaryRow("Subtotal", "$75", bold = false)
            SummaryRow("Shipping", "$5", bold = false)
            SummaryRow("Total", "$80", bold = true)

            Spacer(Modifier.height(25.dp))

            Button(
                onClick = onPurchase,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E88E5) // bouton bleu
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Checkout",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun CartItemRow(name: String, price: Int, image: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$$price",
                color = Color(0xFF4A90E2)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CircleButton("-")
            Text(text = "1", fontWeight = FontWeight.Bold)
            CircleButton("+")
        }
    }
}

@Composable
fun CircleButton(symbol: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0xFFE7ECF5))
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SummaryRow(label: String, value: String, bold: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = value,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}
