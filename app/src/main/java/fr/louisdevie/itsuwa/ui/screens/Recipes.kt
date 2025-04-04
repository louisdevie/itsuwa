package fr.louisdevie.itsuwa.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme
import kotlinx.serialization.Serializable

@Serializable
data object RecipesRoute

@Composable
fun RecipesScreen() {
  Text("Hello, Recipes!")
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        RecipesScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        RecipesScreen()
    }
}