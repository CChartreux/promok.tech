package com.promok.tech.old.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.js.Date

object DateTimeFormatter {
    fun getCurrentTime(): String {
        val date = Date()
        return "${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}"
    }

    fun getCurrentDate(): String {
        val date = Date()
        return "${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${
            date.getDate().toString().padStart(2, '0')
        }"
    }

    fun timeFlow(intervalMs: Long = 1000): Flow<String> = flow {
        while (true) {
            emit(getCurrentTime())
            delay(intervalMs)
        }
    }

    fun dateFlow(intervalMs: Long = 1000): Flow<String> = flow {
        while (true) {
            emit(getCurrentDate())
            delay(intervalMs)
        }
    }
}