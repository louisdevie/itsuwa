package fr.louisdevie.itsuwa.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.louisdevie.itsuwa.DatabaseNotSetUpYetException
import fr.louisdevie.itsuwa.data.repositories.GroceryListItemRepository
import fr.louisdevie.itsuwa.data.entities.GroceryListItem

object ItsuwaDatabase {
    @Database(entities = [GroceryListItem::class], version = 1)
    abstract class Schema : RoomDatabase() {
        abstract fun groceryListItems(): GroceryListItemRepository
    }

    private var _db: Schema? = null

    fun setup(applicationContext: Context) {
        _db = Room.databaseBuilder(applicationContext, Schema::class.java, "itsuwa-main").build()
    }

    private fun <T> require(dao: Schema.() -> T): T {
        return dao.invoke(_db ?: throw DatabaseNotSetUpYetException())
    }

     fun groceryListItems(): GroceryListItemRepository {
        return require { groceryListItems() }
    }
}
