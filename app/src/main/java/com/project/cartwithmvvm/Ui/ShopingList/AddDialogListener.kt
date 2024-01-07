package com.project.cartwithmvvm.Ui.ShopingList

import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem

interface AddDialogListener {
    fun addOnButtonClick(item: ShopingItem)
}