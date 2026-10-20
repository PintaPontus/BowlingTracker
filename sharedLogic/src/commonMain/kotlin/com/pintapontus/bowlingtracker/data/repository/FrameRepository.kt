package com.pintapontus.bowlingtracker.data.repository

import com.pintapontus.bowlingtracker.data.dao.FrameDao
import com.pintapontus.bowlingtracker.data.entity.Frame
import kotlinx.coroutines.flow.Flow

class FrameRepository(private val frameDao: FrameDao) {
    val allNotes: Flow<List<Frame>> = frameDao.getAllFrames()

    suspend fun insert(note: Frame) {
        frameDao.insertFrame(note)
    }
}