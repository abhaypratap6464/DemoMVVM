package com.android.example.demomvvm.di


import com.android.example.demomvvm.data.DemoDataSource
import com.android.example.demomvvm.data.DemoRepository
import com.android.example.demomvvm.data.local.LocalDB
import com.android.example.demomvvm.data.remote.DemoApi
import org.koin.dsl.module

val databaseModule = module {
    single { LocalDB.createRemindersDao(get()) }
}

val apiModule = module {
    single {
        return@single DemoApi.createRetrofitService()
    }
}

val repositoryModule = module {
    single { DemoRepository(get(), get()) }
}


