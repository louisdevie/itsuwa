package fr.louisdevie.itsuwa.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GroceryListItem (
    @PrimaryKey(autoGenerate = true) var id: Long,
    var label: String,
)
