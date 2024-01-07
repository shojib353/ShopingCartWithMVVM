package com.project.cartwithmvvm.Data.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem

@Dao
interface ShopingDau {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShopingItem)

    @Delete
    suspend fun delete(item: ShopingItem)

    @Query("SELECT * FROM ShopingItem")
    fun getAllItem():LiveData<List<ShopingItem>>
}