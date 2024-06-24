package com.example.srinivas_22bce9653.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    // curd
    @Insert(onConflict = OnConflictStrategy.REPLACE) // insert into item(id, name, price, quantity)
    suspend fun insert(groceryItem: Item)

    @Update
    suspend   fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :itemId")
    fun getItem(itemId: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
    @Query("SELECT * FROM item WHERE id = :id LIMIT 1")
    suspend fun getItemById(id: Int): Item?
}