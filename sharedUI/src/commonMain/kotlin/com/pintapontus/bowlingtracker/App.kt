package com.pintapontus.bowlingtracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import bowlingtracker.sharedui.generated.resources.Res
import bowlingtracker.sharedui.generated.resources.compose_multiplatform
import com.pintapontus.bowlingtracker.data.entity.Frame
import com.pintapontus.bowlingtracker.data.repository.FrameRepository
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App(frameRepo: FrameRepository? = null) {

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                showContent = !showContent
                runBlocking {
                    frameRepo?.insert(Frame(0, "title", "content"))
                }
            }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val frames by (frameRepo?.allNotes ?: kotlinx.coroutines.flow.flowOf(emptyList()))
                    .collectAsState(initial = emptyList())
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Frames: $frames")
                }
            }
        }
    }
}