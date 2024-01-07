package com.project.cartwithmvvm.Data.Repository

import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem
import com.project.cartwithmvvm.Data.DB.ShopingDatabase

class ShopingRepository (private val db:ShopingDatabase){
    suspend fun insert(item: ShopingItem)=db.getShopingDao().insert(item)
    suspend fun delete(item: ShopingItem)=db.getShopingDao().delete(item)
    fun getAllItem()=db.getShopingDao().getAllItem()
}