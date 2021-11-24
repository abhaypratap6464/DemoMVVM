package com.android.example.demoMvvM.data.local

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.local.dao.DemoDao
import com.android.example.demoMvvM.data.local.dao.RemoteKeysDao

/**
 * The Room Database that contains the issue table.
 */
@Database(entities = [IssuesDTO::class, RemoteKeys::class], version = 2, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract val demoDao : DemoDao
    abstract val remoteKeyDao : RemoteKeysDao


    companion object {

        @Volatile
        private var INSTANCE: DemoDatabase? = null

        fun getInstance(context: Context): DemoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DemoDatabase::class.java,
                        "demo_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}