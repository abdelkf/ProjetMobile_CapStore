package com.capStore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capStore.screens.*

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeScreen(onStartClick = { navController.navigate("login") })
        }

        composable("login") {
            LoginScreen(
                onLogin = { navController.navigate("home") },
                onRegisterNavigate = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterScreen(onRegister = { navController.navigate("login") },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("products") {
            ProductListScreen(navController=navController,
                onProductClick = {id -> navController.navigate("productDetail/$id")
            })
        }

        composable("productDetail/{productId}") { backStack ->
            val id = backStack.arguments?.getString("productId") ?: "0"
            DetailBottomNavigationBar(navController=navController,productId = id, onAddToCart = { navController.navigate("cart") })
        }

        composable("cart") {
            CartBottomNavigationBar(navController=navController,
                onPurchase = { navController.navigate("confirm") })
        }

        composable("confirm") {
            //PurchaseConfirmationScreen(onHome = { navController.navigate("welcome") })
            PurchaseConfirmationScreenApp(navController)
        }

        composable("error") {
            ErrorScreen(onRetry = { navController.navigate("welcome") })
        }
        composable("home") { HomeBottomNavigationBar(navController) }

        composable("account") { AccountBottomNavigationBar(navController) }

    }
}
