package com.promok.tech.app.workstation.components.lockscreen.reusable.clock

import kotlin.js.Date

class Clock(clockFormat: Set<ClockFormat>) {
    private val clockFormat: Set<ClockFormat> = run {
        clockFormat.flatMap { clockFormat ->
            if (clockFormat == ClockFormat.SHOW_ALL) {
                listOf(
                    ClockFormat.SHOW_HOURS,
                    ClockFormat.SHOW_MINUTES,
                    ClockFormat.SHOW_SECONDS
                )
            } else listOf(clockFormat)
        }.toSet()
    }

    private fun getHours(hours: Int): String {
        return when {
            clockFormat.contains(ClockFormat.TWENTY_FOUR_HOUR) -> hours.toString().padStart(2, '0')
            else -> when {
                hours > 12 -> (hours - 12).toString().padStart(2, '0')
                else -> hours.toString().padStart(2, '0')
            }
        }
    }

    private fun getMinutes(minutes: Int): String {
        return minutes.toString().padStart(2, '0')
    }

    private fun getSeconds(seconds: Int): String {
        return seconds.toString().padStart(2, '0')
    }

    fun getTime(): String {
        val dateTime = Date()

        return buildString {
            if (clockFormat.contains(ClockFormat.SHOW_HOURS)) append(getHours(dateTime.getHours()))
            if (clockFormat.contains(ClockFormat.SHOW_MINUTES)) append(":" + getMinutes(dateTime.getMinutes()))
            if (clockFormat.contains(ClockFormat.SHOW_SECONDS)) append(":" + getSeconds(dateTime.getSeconds()))
        }
    }
}