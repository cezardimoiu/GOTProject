package com.example.gotproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DataCharactersItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDBInstance(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "APP_DATABASE")
                        .allowMainThreadQueries()
                        .build()
            }
            return DB_INSTANCE!!
        }
    }
}