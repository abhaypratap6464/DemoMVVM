package com.android.example.demoMvvM.core

import android.app.Application
import com.android.example.demoMvvM.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }


    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
            modules(
                listOf(databaseModule, apiModule, repositoryModule, issueViewModel,issueDetailViewModel)
            )
        }
    }

}