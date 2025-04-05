package fr.louisdevie.itsuwa.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import fr.louisdevie.itsuwa.logic.GroceryList
import fr.louisdevie.itsuwa.ui.components.AddNewRow
import fr.louisdevie.itsuwa.ui.components.GroceryListRow
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data object GroceryListRoute

@Composable
fun GroceryListScreen() {
    val coroutineScope = rememberCoroutineScope()
    val groceryList = remember { GroceryList() }

    LaunchedEffect(Unit) {
        groceryList.loadSavedItems()
    }

    Column {
        groceryList.items.forEach { item ->
            GroceryListRow(item.label, onDone = {
                coroutineScope.launch {
                    groceryList.removeItem(item)
                }
            })
        }
        HorizontalDivider()
        AddNewRow(onAdd = { label ->
            val item = groceryList.newItem(label)
            coroutineScope.launch {
                groceryList.saveItem(item)
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryListScreenPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        GroceryListScreen()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun GroceryListScreenPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        GroceryListScreen()
    }
}