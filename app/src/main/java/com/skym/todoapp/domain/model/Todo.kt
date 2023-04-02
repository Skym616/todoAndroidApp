package com.skym.todoapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "complete") val complete: Boolean,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "end_time") val endTime: String,
    @ColumnInfo(name = "start_time") val startTime: String,
)
