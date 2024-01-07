package com.project.cartwithmvvm.Data.DB.Entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShopingItem")
data class ShopingItem(
    @ColumnInfo(name = "item_name")
    var name:String,
    @ColumnInfo(name = "item_amount")
    var amount:Int,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}