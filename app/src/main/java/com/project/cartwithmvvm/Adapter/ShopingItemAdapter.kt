package com.project.cartwithmvvm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem
import com.project.cartwithmvvm.R
import com.project.cartwithmvvm.Ui.ShopingList.ShopingViewModel


class ShopingItemAdapter(var item:List<ShopingItem>,private val viewModel: ShopingViewModel):RecyclerView.Adapter<ShopingItemAdapter.ShopingViewHolder>() {
    inner class ShopingViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name=view.findViewById<TextView>(R.id.tvname)
        val amount=view.findViewById<TextView>(R.id.tvamount)
        val delete=view.findViewById<ImageView>(R.id.delete)
        val minus=view.findViewById<ImageView>(R.id.minus)
        val plus=view.findViewById<ImageView>(R.id.plus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.shoping_item,parent,false)
        return ShopingViewHolder(view)
    }

    override fun getItemCount(): Int {
       return item.size
    }

    override fun onBindViewHolder(holder: ShopingViewHolder, position: Int) {
       val currentShopingItem=item[position]
        holder.name.text=currentShopingItem.name
        holder.amount.text="${currentShopingItem.amount}"
        holder.delete.setOnClickListener{
            viewModel.delete(currentShopingItem)
        }
        holder.plus.setOnClickListener{
            currentShopingItem.amount++
            viewModel.insert(currentShopingItem)
        }
        holder.minus.setOnClickListener{
            if (currentShopingItem.amount>0){
                currentShopingItem.amount--
            viewModel.insert(currentShopingItem)
            }
        }
    }
}