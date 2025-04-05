package fr.louisdevie.itsuwa.data.repositories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fr.louisdevie.itsuwa.data.entities.GroceryListItem

@Dao
interface GroceryListItemRepository {
    @Query("SELECT * FROM GroceryListItem")
    suspend fun getAll(): List<GroceryListItem>

    @Insert
    suspend fun insert(user: GroceryListItem): Long

    @Delete
    suspend fun delete(user: GroceryListItem)
}