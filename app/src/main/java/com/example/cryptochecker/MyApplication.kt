package com.example.cryptochecker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    private val myModule = module {
        single { ServiceRepository(get()) }
        single { RetrofitClient() }
        single { MainFragment(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            androidFileProperties()

            fragmentFactory()

            modules(mutableListOf(myModule, viewModelModule))
        }
    }
}