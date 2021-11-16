package com.android.example.demomvvm.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.example.demomvvm.data.dto.IssuesDTO

@Dao
interface DemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIssues(vararg issues: IssuesDTO)

    @Query("SELECT * FROM issues")
     fun getAllIssues(): LiveData<List<IssuesDTO>>

}