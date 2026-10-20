package com.pintapontus.bowlingtracker.data

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class IosFrameStore {
    private val repository = FrameRepositoryProvider.get()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    /** Chiama onChange ogni volta che i dati cambiano. Restituisce il Job per poterlo annullare. */
    fun observe(onChange: (List<Frame>) -> Unit): Job =
        repository.allNotes
            .onEach(onChange)
            .launchIn(scope)

    fun insert(title: String, content: String) {
        scope.launch {
            repository.insert(Frame(title = title, content = content))
        }
    }
}