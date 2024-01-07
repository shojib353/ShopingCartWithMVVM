package com.project.cartwithmvvm.Ui.ShopingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.cartwithmvvm.Data.Repository.ShopingRepository

class ShopingViewModelFactory( private val repository: ShopingRepository)
    :ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShopingViewModel(repository) as T
    }
}