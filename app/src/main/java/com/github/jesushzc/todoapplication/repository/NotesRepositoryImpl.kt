package com.github.jesushzc.todoapplication.repository

import com.github.jesushzc.todoapplication.database.NotesDB
import com.github.jesushzc.todoapplication.domain.Notes
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesDB: NotesDB
): NotesRepository {

    override suspend fun insert(notes: Notes) {
        notesDB.notesDao().insert(notes)
    }

    override suspend fun markAsCompleted(id: Int, isCompleted: Boolean) {
        notesDB.notesDao().markAsCompleted(id, isCompleted)
    }

    override suspend fun markAsPrivate(id: Int, isPrivate: Boolean) {
        notesDB.notesDao().markAsPrivate(id, isPrivate)
    }

    override suspend fun getAllCompleted(): List<Notes> {
        return notesDB.notesDao().getAllCompleted()
    }

    override suspend fun getAllPrivate(): List<Notes> {
        return notesDB.notesDao().getAllPrivate()
    }

    override suspend fun getAllPublic(): List<Notes> {
        return notesDB.notesDao().getAllPublic()
    }

    override suspend fun getNotesById(id: Int): Notes {
        return notesDB.notesDao().getNotesById(id)
    }

    override suspend fun update(notes: Notes) {
        notesDB.notesDao().update(notes)
    }

    override suspend fun delete(id: Int) {
        notesDB.notesDao().delete(id)
    }
}