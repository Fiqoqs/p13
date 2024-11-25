package com.example.p13

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Voter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun voterDao(): VoterDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "voter_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
