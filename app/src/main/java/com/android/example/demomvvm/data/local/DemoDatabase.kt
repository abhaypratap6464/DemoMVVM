package com.android.example.demomvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.example.demomvvm.data.dto.IssuesDTO
import com.android.example.demomvvm.data.remote.model.Issues

/**
 * The Room Database that contains the issue table.
 */
@Database(entities = [IssuesDTO::class], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun demoDao(): DemoDao
}