package com.example.gotproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DataCharactersItem::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        private var DB_INSTANCE: AppDB? = null

        fun getAppDBInstance(context: Context): AppDB {
            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(context.applicationContext, AppDB::class.java, "APP_DATABASE")
                        .allowMainThreadQueries()
                        .build()
            }
            return DB_INSTANCE!!
        }
    }
}