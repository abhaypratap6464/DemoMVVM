package com.android.example.demomvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * The Room Database that contains the reminders table.
 */
@Database(entities = [], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun demoDao(): DemoDao
}