package com.github.jesushzc.todoapplication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.github.jesushzc.todoapplication.domain.Notes

@Dao
interface NotesDao {
    //Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: Notes)

    //Mark as completed
    @Query("UPDATE notes SET isCompleted = :isCompleted WHERE id = :id")
    suspend fun markAsCompleted(id: Int, isCompleted: Boolean)

    //Mark as private
    @Query("UPDATE notes SET isPrivate = :isPrivate WHERE id = :id")
    suspend fun markAsPrivate(id: Int, isPrivate: Boolean)

    //Get all completed
    @Query("SELECT * FROM notes WHERE isCompleted = 1")
    suspend fun getAllCompleted(): List<Notes>

    //Get all private
    @Query("SELECT * FROM notes WHERE isPrivate = 1")
    suspend fun getAllPrivate(): List<Notes>

    //Get all public
    @Query("SELECT * FROM notes WHERE isPrivate = 0")
    suspend fun getAllPublic(): List<Notes>

    //Get notes by id
    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNotesById(id: Int): Notes

    //Update
    @Update
    suspend fun update(notes: Notes)

    //Delete
    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun delete(id: Int)
}