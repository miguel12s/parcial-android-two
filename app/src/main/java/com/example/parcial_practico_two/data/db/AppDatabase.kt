package com.example.parcial_practico_two.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_practico_two.data.model.NotaModel

@Database(entities = [NotaModel::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun NotaDao(): NotaDao

    companion object {
        @Volatile

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ra_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}