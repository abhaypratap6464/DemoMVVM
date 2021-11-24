package com.android.example.demoMvvM.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.android.example.demoMvvM.data.local.DemoDatabase
import com.android.example.demoMvvM.data.remote.DemoApi
import com.android.example.demoMvvM.data.remote.DemoApiService
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
//Medium Test to test the repository
@MediumTest
class DemoRepositoryTest : TestCase() {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: DemoDatabase
    private lateinit var repository: DemoRepository
    private lateinit var service: DemoApiService

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DemoDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        service = DemoApi.createRetrofitService()
        repository = DemoRepository(service, database.demoDao, Dispatchers.Main)
    }

    @After
    fun closeDb() {
        database.close()
    }

    fun testGetIssueDetails() {}

    fun testGetIssue() {}

    fun testGetAllIssues() {}
}