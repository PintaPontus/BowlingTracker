package com.pintapontus.bowlingtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pintapontus.bowlingtracker.data.FrameRepositoryProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val frameRepo = FrameRepositoryProvider.get(applicationContext)

        setContent {
            App(frameRepo)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}