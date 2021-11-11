package com.android.example.demomvvm.data.local

import android.content.Context
import androidx.room.Room


/**
 * Singleton class that is used to create a reminder db
 */
object LocalDB {

    /**
     * static method that creates a reminder class and returns the DAO of the reminder
     */
    fun createRemindersDao(context: Context): DemoDao {
        return Room.databaseBuilder(
            context.applicationContext,
            DemoDatabase::class.java, "database.db"
        ).build().demoDao()
    }

}