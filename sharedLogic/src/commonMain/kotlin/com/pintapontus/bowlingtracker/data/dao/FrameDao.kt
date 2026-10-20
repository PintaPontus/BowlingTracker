package com.pintapontus.bowlingtracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pintapontus.bowlingtracker.data.entity.Frame
import kotlinx.coroutines.flow.Flow

@Dao
interface FrameDao {
    @Query("SELECT * FROM frame")
    fun getAllFrames(): Flow<List<Frame>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFrame(note: Frame)
}