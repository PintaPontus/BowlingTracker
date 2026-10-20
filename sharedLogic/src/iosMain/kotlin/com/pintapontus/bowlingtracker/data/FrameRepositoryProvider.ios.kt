package com.pintapontus.bowlingtracker.data

import com.pintapontus.bowlingtracker.data.repository.FrameRepository

object FrameRepositoryProvider {
    private val instance: FrameRepository by lazy {
        FrameRepository(getDatabaseBuilder().build().frameDao())
    }

    fun get(): FrameRepository = instance
}