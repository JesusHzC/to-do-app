package com.github.jesushzc.todoapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.jesushzc.todoapplication.database.dao.NotesDao
import com.github.jesushzc.todoapplication.domain.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NotesDB: RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        private const val DB_NAME = "notes.db"

        @Volatile
        private var instance: NotesDB? = null

        fun getInstance(context: Context): NotesDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NotesDB {
            return Room.databaseBuilder(
                context,
                NotesDB::class.java,
                DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}