package com.pintapontus.bowlingtracker.data

import android.content.Context
import com.pintapontus.bowlingtracker.data.repository.FrameRepository

object FrameRepositoryProvider {
    @Volatile
    private var instance: FrameRepository? = null

    fun get(context: Context): FrameRepository =
        instance ?: synchronized(this) {
            instance ?: FrameRepository(
                getDatabaseBuilder(context).build().frameDao()
            ).also { instance = it }
        }
}