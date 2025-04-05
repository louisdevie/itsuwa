package fr.louisdevie.itsuwa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.louisdevie.itsuwa.data.ItsuwaDatabase
import fr.louisdevie.itsuwa.ui.Main
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ItsuwaDatabase.setup(applicationContext)
        setContent { ItsuwaTheme { Main() } }
    }
}
