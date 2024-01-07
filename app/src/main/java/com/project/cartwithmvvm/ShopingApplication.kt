package com.project.cartwithmvvm

import android.app.Application
import com.project.cartwithmvvm.Data.DB.ShopingDatabase
import com.project.cartwithmvvm.Data.Repository.ShopingRepository
import com.project.cartwithmvvm.Ui.ShopingList.ShopingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class ShopingApplication:Application(),KodeinAware {
    override val kodein: Kodein = Kodein.lazy {


        import(androidXModule(this@ShopingApplication))
        bind() from singleton { ShopingDatabase(instance()) }
        bind() from singleton { ShopingRepository(instance()) }
        bind() from provider {
            ShopingViewModelFactory(instance())
        }
    }



}