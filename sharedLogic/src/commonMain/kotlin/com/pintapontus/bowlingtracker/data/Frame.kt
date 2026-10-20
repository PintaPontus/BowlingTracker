package com.pintapontus.bowlingtracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frame")
data class Frame(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String
)