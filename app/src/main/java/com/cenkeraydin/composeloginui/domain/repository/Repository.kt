package com.cenkeraydin.composeloginui.domain.repository

import com.cenkeraydin.composeloginui.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllNotes(): Flow<List<Note>>
    fun getNoteById(noteId: Long): Flow<Note>
    suspend fun insert(note: Note)
    suspend fun update(note: Note)
    suspend fun delete(id: Long)
    fun getFavoritedNotes(): Flow<List<Note>>

}