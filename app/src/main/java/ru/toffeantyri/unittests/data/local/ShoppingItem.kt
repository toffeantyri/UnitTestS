package ru.toffeantyri.unittests.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = RoomConstants.TABLE_SHOPPING_ITEMS)
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true) var id: Int? = null
) {
}