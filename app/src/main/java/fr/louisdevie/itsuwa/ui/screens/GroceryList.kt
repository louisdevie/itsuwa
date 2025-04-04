package fr.louisdevie.itsuwa.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme
import kotlinx.serialization.Serializable

@Serializable
data object GroceryListRoute

@Composable
fun GroceryListScreen() {
  Text("Hello, Grocery List!")
}

@Preview(showBackground = true)
@Composable
fun GroceryListScreenPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        GroceryListScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryListScreenPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        GroceryListScreen()
    }
}