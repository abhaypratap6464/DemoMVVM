package com.android.example.demoMvvM.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.local.DemoDatabase
import com.google.common.truth.Truth.assertThat

import org.junit.runner.RunWith;

import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
//Unit test the DAO
@SmallTest
class DemoDaoTest {

    //use in memory builder
    //always close the database

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: DemoDatabase

    @Before
    fun initDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DemoDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun saveIssuesAndIssues() = runBlockingTest {
        val issue1 = IssuesDTO("A",1,"Title 1","Description 1","User A","12-Nov-2021","https://avatars.githubusercontent.com/u/231923?v=4",2)
        val issue2 = IssuesDTO("B",2,"Title 2","Description 2","User B","12-Nov-2021","https://avatars.githubusercontent.com/u/231923?v=4",2)
        val issue3 = IssuesDTO("C",3,"Title 3","Description 3","User C","12-Nov-2021","https://avatars.githubusercontent.com/u/231923?v=4",2)

        database.demoDao.insertAllIssues(listOf(issue1,issue2,issue3))


        val issueList = database.demoDao.getAllIssues()

      //  assertThat(issueList).hasSize(3)
       // assertThat(issueList).contains(issue1)
    }

    @Test
    fun getIssues_noIssuesSaved_returnsEmpty() = runBlockingTest {
        val reminderList = database.demoDao.getAllIssues()
        assertThat(reminderList).isNotNull()
        assertThat(reminderList)
    }


}

