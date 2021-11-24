package com.android.example.demoMvvM.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.example.demoMvvM.data.dto.IssuesDTO

@Dao
interface DemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIssues(list: List<IssuesDTO>)

    @Query("SELECT * FROM issues")
    fun getAllIssues(): LiveData<List<IssuesDTO>>

    @Query("SELECT * FROM issues")
    fun getAllIssue(): PagingSource<Int, IssuesDTO>

    @Query("DELETE FROM issues")
    fun clearAll()

}