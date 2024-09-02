package com.cenkeraydin.composeloginui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cenkeraydin.composeloginui.data.local.model.Note

@TypeConverters(DateConverter::class)
@Database(
    entities = [Note::class],
    version =1,
    exportSchema = false)
abstract class NoteDatabase :RoomDatabase() {
    abstract val noteDao: NoteDao
}