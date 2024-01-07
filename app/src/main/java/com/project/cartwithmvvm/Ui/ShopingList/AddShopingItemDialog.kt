package com.project.cartwithmvvm.Ui.ShopingList

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem
import com.project.cartwithmvvm.R

class AddShopingItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shoping_item)

        val add=findViewById<TextView>(R.id.tvadd)
        val etname=findViewById<TextView>(R.id.etname)
        val etamount=findViewById<TextView>(R.id.etam)
        val cancle=findViewById<TextView>(R.id.tvcancle)

        add?.setOnClickListener {
            val name=etname?.text.toString()
            val amount=etamount?.text.toString()

            if (name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context,"Please Enter All Information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item=ShopingItem(name,amount.toInt())
            addDialogListener.addOnButtonClick(item)
            dismiss()
        }
        cancle?.setOnClickListener {
            cancel()
        }


    }

}