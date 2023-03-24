package com.github.jesushzc.todoapplication.repository

import com.github.jesushzc.todoapplication.domain.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun insert(notes: Notes)
    suspend fun markAsCompleted(id: Int, isCompleted: Boolean)
    suspend fun markAsPrivate(id: Int, isPrivate: Boolean)
    suspend fun getAllCompleted(): Flow<List<Notes>>
    suspend fun getAllPrivate(): Flow<List<Notes>>
    suspend fun getAllPublic(): Flow<List<Notes>>
    suspend fun getNotesById(id: Int): Flow<Notes>
    suspend fun update(notes: Notes)
    suspend fun delete(id: Int)
}