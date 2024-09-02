package com.cenkeraydin.composeloginui.data.local

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun toDate(date: Long?): Date {
        return date?.let { Date(it) } ?: Date()
    }

    @TypeConverter
    fun fromDate(date: Date?): Long {
        return date?.time ?: Date().time
    }
}