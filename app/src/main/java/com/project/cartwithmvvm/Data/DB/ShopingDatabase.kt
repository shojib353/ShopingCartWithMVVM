package com.project.cartwithmvvm.Data.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem

@Database(entities = [ShopingItem::class],
                        version = 1)
abstract class ShopingDatabase:RoomDatabase() {
    abstract fun getShopingDao(): ShopingDau
    companion object{
        @Volatile
        private var instance: ShopingDatabase?=null
        private val lock=Any()
        operator fun invoke(context: Context)= instance ?: synchronized(lock){
            instance ?: createDatabase(context).also { instance =it }
        }

        private fun createDatabase(Context:Context)=
            Room.databaseBuilder(Context.applicationContext,
                ShopingDatabase::class.java,"Shopping.db").build()
    }
}