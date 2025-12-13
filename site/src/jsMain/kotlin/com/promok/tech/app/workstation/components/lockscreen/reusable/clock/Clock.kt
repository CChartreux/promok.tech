package com.promok.tech.app.workstation.components.lockscreen.reusable.clock

import kotlin.js.Date

class Clock(val clockTheme: ClockTheme) {
    private var _hours: Int = 0
        set(value) {
            require(value in 0..23)
            field = value
        }
    private var _minutes: Int = 0
        set(value) {
            require(value in 0..59)
            field = value
        }
    private var _seconds: Int = 0
        set(value) {
            require(value in 0..59)
            field = value
        }


    private fun getHours(clockFormat: Set<ClockFormat>): String {
        return when {
            clockFormat.contains(ClockFormat.TWENTY_FOUR_HOUR) -> _hours.toString().padStart(2, '0')
            else -> when {
                _hours > 12 -> (_hours - 12).toString().padStart(2, '0')
                else -> _hours.toString().padStart(2, '0')
            }
        }
    }

    private fun getMinutes(): String {
        return _minutes.toString().padStart(2, '0')
    }

    private fun getSeconds(): String {
        return _seconds.toString().padStart(2, '0')
    }

    private fun fetchTime() {
        val dateTime = Date()

        _hours = dateTime.getHours()
        _minutes = dateTime.getMinutes()
        _seconds = dateTime.getSeconds()
    }

    fun getTime(): String {
        fetchTime()

        return buildString {
            if (clockTheme.clockFormat.contains(ClockFormat.SHOW_HOURS)) append(getHours(clockTheme.clockFormat))
            if (clockTheme.clockFormat.contains(ClockFormat.SHOW_MINUTES)) append(":" + getMinutes())
            if (clockTheme.clockFormat.contains(ClockFormat.SHOW_SECONDS)) append(":" + getSeconds())
        }
    }
}