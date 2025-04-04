package fr.louisdevie.itsuwa.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme
import kotlinx.serialization.Serializable

@Serializable
data object FridgeRoute

@Composable
fun FridgeScreen() {
  Text("Hello, Fridge!")
}

@Preview(showBackground = true)
@Composable
fun FridgeScreenPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        FridgeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun FridgeScreenPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        FridgeScreen()
    }
}