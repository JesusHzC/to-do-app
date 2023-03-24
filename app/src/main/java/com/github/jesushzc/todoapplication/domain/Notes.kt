package com.github.jesushzc.todoapplication.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long,
    val isCompleted: Boolean,
    val isPrivate: Boolean
)
