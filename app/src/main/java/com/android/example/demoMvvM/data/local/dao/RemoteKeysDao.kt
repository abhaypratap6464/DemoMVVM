package com.android.example.demoMvvM.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.example.demoMvvM.data.local.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRemote(list: List<RemoteKeys>)

    @Query("SELECT * FROM remoteKey WHERE repoId = :id")
    fun getRemoteKeys(id: String): RemoteKeys

    @Query("DELETE FROM remoteKey")
    fun clearAll()
}