package fr.louisdevie.itsuwa.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    secondaryContainer = Green900
)

private val LightColorScheme = lightColorScheme(
    secondaryContainer = Green300
)

@Composable
fun ItsuwaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (ColorScheme) -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = { content(colorScheme) }
    )
}