package ru.toffeantyri.unittests.data.local

import androidx.room.Database

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingItemsDatabase {

    abstract fun shoppingDao(): ShoppingDao
}