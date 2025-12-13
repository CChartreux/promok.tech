package com.promok.tech.app.workstation.components.lockscreen.reusable.date

import androidx.compose.runtime.*
import com.promok.tech.app.workstation.components.Components
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date

class DateComponent(val dateTheme: DateTheme) : Components {
    private val months = arrayOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    private val days = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )

    private fun getDay(day: Int): String = days.getOrElse(day - 1) {
        throw IllegalArgumentException("Invalid day: $day")
    }

    private fun getMonth(month: Int) = months.getOrElse(month) {
        throw IllegalArgumentException("Invalid month: $month")
    }

    //private fun getDateString()

    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }
        var dateString by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                if (dateTheme.dateFormat.contains(DateFormat.SHOW_ALL)) {
                    dateString =
                        getDay(date.getDay()) + ", " + date.getDay()
                            .toString() + ". " + getMonth(date.getMonth()) + " " + date.getFullYear().toString()
                } else {
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_DAY_NAME)) dateString =
                        getDay(date.getDay()) + ", "
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_DAY)) dateString += date.getDay()
                        .toString() + ". "
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_MONTH_NAME)) dateString += getMonth(date.getMonth()) + " "
                    else if (dateTheme.dateFormat.contains(DateFormat.SHOW_MONTH)) dateString += date.getMonth()
                        .toString() + " "
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_YEAR)) dateString += date.getFullYear().toString()
                    else if (dateTheme.dateFormat.contains(DateFormat.SHOW_YEAR_ABBREVIATION)) dateString += date.getFullYear()
                        .toString().substring(2)
                }

                delay(1000)
            }
        }

        Column(
            modifier = Modifier
                .color(dateTheme.textColor)
                .fontSize(dateTheme.fontSize)
                .fontWeight(dateTheme.fontWeight)
                .fontFamily(dateTheme.fontFamily)
        ) {
            Text(dateString)
        }
    }
}