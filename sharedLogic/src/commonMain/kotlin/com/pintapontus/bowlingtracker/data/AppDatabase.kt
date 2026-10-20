package com.pintapontus.bowlingtracker.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.pintapontus.bowlingtracker.data.dao.FrameDao
import com.pintapontus.bowlingtracker.data.entity.Frame

@Database(entities = [Frame::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun frameDao(): FrameDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}