package com.cenkeraydin.composeloginui.data.repository

import com.cenkeraydin.composeloginui.data.local.NoteDao
import com.cenkeraydin.composeloginui.data.local.model.Note
import com.cenkeraydin.composeloginui.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) :Repository{
    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override fun getNoteById(noteId: Long): Flow<Note> {
    return noteDao.getNoteById(noteId)
    }

    override suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    override suspend fun update(note: Note) {
        noteDao.update(note)
    }
    override suspend fun delete(id: Long) {
        noteDao.delete(id)
    }
    override fun getFavoritedNotes(): Flow<List<Note>> {
        return noteDao.getFavoritedNotes()
    }
}