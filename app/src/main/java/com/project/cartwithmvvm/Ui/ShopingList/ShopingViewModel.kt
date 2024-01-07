package com.project.cartwithmvvm.Ui.ShopingList

import androidx.lifecycle.ViewModel
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem
import com.project.cartwithmvvm.Data.Repository.ShopingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopingViewModel (private val repository: ShopingRepository):ViewModel(){

    fun insert(item: ShopingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShopingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllShopingItem()=repository.getAllItem()
}