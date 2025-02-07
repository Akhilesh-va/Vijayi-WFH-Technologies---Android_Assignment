package com.example.cryptocurrencyappmvvm

import android.app.Application
import com.example.cryptocurrencyappmvvm.di.appModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CryptoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoApplication)
            modules(appModule)
            androidLogger()

        }
    }
}

