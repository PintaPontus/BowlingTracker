package com.pintapontus.bowlingtracker.data.repository

import com.pintapontus.bowlingtracker.data.Frame
import com.pintapontus.bowlingtracker.data.FrameDao
import kotlinx.coroutines.flow.Flow

class FrameRepository(private val frameDao: FrameDao) {
    val allNotes: Flow<List<Frame>> = frameDao.getAllFrames()

    suspend fun insert(note: Frame) {
        frameDao.insertFrame(note)
    }
}