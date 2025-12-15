package com.promok.tech.app.workstation.components.reusable.date

import kotlin.js.Date

class Date(dateFormat: Set<DateFormat>) {
    private val dateFormat: Set<DateFormat> = run {
        dateFormat.flatMap { dateFormat ->
            if (dateFormat == DateFormat.SHOW_ALL) {
                listOf(
                    DateFormat.SHOW_YEAR,
                    DateFormat.SHOW_MONTH,
                    DateFormat.SHOW_DAY
                )
            } else {
                listOf(dateFormat)
            }
        }.toSet()
    }

    private val months = arrayOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    private val days = arrayOf(
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    )


    private fun getDayName(day: Int): String = days.getOrElse(day) {
        throw IllegalArgumentException("Invalid day: $day")
    }

    private fun getMonthName(month: Int) = months.getOrElse(month) {
        throw IllegalArgumentException("Invalid month: $month")
    }

    fun getDate(): String {
        val date = Date()

        return buildString {
            if (dateFormat.contains(DateFormat.SHOW_DAY_NAME)) append(getDayName(date.getDay()) + ", ")
            if (dateFormat.contains(DateFormat.SHOW_DAY)) append(date.getDay().toString() + ". ")
            if (dateFormat.contains(DateFormat.SHOW_MONTH_NAME)) append(getMonthName(date.getMonth()) + " ")
            else if (dateFormat.contains(DateFormat.SHOW_MONTH)) append(date.getMonth().toString() + " ")
            if (dateFormat.contains(DateFormat.SHOW_YEAR)) append(date.getFullYear().toString())
            else if (dateFormat.contains(DateFormat.SHOW_YEAR_ABBREVIATION)) append(
                date.getFullYear().toString().substring(2)
            )
        }
    }
}