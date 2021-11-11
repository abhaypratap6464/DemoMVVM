package com.android.example.demomvvm.data


import com.android.example.demomvvm.data.local.DemoDao
import com.android.example.demomvvm.data.remote.DemoApiService

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class DemoRepository(
    private val service: DemoApiService,
    private val dao: DemoDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : DemoDataSource