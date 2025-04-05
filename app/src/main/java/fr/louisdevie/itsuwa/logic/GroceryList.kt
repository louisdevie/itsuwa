package fr.louisdevie.itsuwa.logic

import androidx.compose.runtime.mutableStateListOf
import fr.louisdevie.itsuwa.data.ItsuwaDatabase
import fr.louisdevie.itsuwa.data.entities.GroceryListItem

class GroceryList {
    private var _items = mutableStateListOf<GroceryListItem>()

    val items: List<GroceryListItem>
        get() {
            return _items
        }

    suspend fun loadSavedItems() {
        _items.addAll(ItsuwaDatabase.groceryListItems().getAll())
    }

    fun newItem(label: String): GroceryListItem {
        return GroceryListItem(0, label)
    }

    suspend fun saveItem(item: GroceryListItem) {
        if (item.id == 0L) {
            val id = ItsuwaDatabase.groceryListItems().insert(item)
            item.id = id
            _items.add(item)
        }
    }

    suspend fun removeItem(item: GroceryListItem) {
        ItsuwaDatabase.groceryListItems().delete(item)
        _items.remove(item)
    }
}