package com.project.cartwithmvvm.Ui.ShopingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.cartwithmvvm.Adapter.ShopingItemAdapter
import com.project.cartwithmvvm.Data.DB.Entries.ShopingItem
import com.project.cartwithmvvm.Data.DB.ShopingDatabase
import com.project.cartwithmvvm.Data.Repository.ShopingRepository
import com.project.cartwithmvvm.R
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class ShopingActivity : AppCompatActivity(),KodeinAware {
    override val kodein by kodein()
    val factory:ShopingViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping)
        val recycler=findViewById<RecyclerView>(R.id.rvShopingItems)

        val fav=findViewById<Button>(R.id.button3)


      /*  val database=ShopingDatabase(this)
        val repository=ShopingRepository(database)
        val factory=ShopingViewModelFactory(repository)*/

        val viewModel=ViewModelProvider(this,factory).get(ShopingViewModel::class.java)

        val Adapter=ShopingItemAdapter(listOf(),viewModel)
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=Adapter

        viewModel.getAllShopingItem().observe(this, Observer {
            Adapter.item=it
            Adapter.notifyDataSetChanged()
        })


        viewModel.getAllShopingItem().observe(this, Observer {
            var sum=0
            it.forEach{
                sum+=it.amount
            }
            fav.text=sum.toString()
        })


        fav.setOnClickListener {

            AddShopingItemDialog(
                this,
                object :AddDialogListener{
                    override fun addOnButtonClick(item: ShopingItem) {
                        viewModel.insert(item)
                    }
                }).show()

        }

    }
}