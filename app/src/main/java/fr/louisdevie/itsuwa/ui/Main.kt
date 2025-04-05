package fr.louisdevie.itsuwa.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.louisdevie.itsuwa.ui.components.Navbar
import fr.louisdevie.itsuwa.ui.screens.FridgeRoute
import fr.louisdevie.itsuwa.ui.screens.FridgeScreen
import fr.louisdevie.itsuwa.ui.screens.GroceryListRoute
import fr.louisdevie.itsuwa.ui.screens.GroceryListScreen
import fr.louisdevie.itsuwa.ui.screens.RecipesRoute
import fr.louisdevie.itsuwa.ui.screens.RecipesScreen
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme

@Composable
fun Main() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = { Navbar(navController) }) { padding ->
        NavHost(navController, startDestination = GroceryListRoute, modifier = Modifier.padding(padding)) {
            composable<FridgeRoute> { FridgeScreen() }
            composable<GroceryListRoute> { GroceryListScreen() }
            composable<RecipesRoute> { RecipesScreen() }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        Main()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        Main()
    }
}