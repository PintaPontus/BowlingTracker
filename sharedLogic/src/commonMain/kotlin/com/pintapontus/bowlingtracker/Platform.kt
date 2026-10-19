package com.pintapontus.bowlingtracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform