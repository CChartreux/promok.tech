package com.promok.tech.app.components.util.date

import androidx.compose.runtime.*
import com.promok.tech.interfaces.Components
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date

class Date(val dateTheme: DateTheme) : Components {
    private fun getDayString(day: Int): String {
        val dayList = listOf<String>(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        )

        return dayList[day - 1]
    }

    private fun getMonthString(month: Int): String {
        val monthList = listOf<String>(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )

        return monthList[month - 1]
    }

    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }
        var dateString by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                if (dateTheme.dateFormat.contains(DateFormat.SHOW_ALL)) {
                    dateString =
                        getDayString(date.getDay()) + ", " + date.getDay()
                            .toString() + ". " + getMonthString(date.getMonth()) + " " + date.getFullYear().toString()
                } else {
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_DAY_NAME)) dateString =
                        getDayString(date.getDay()) + ", "
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_DAY)) dateString += date.getDay()
                        .toString() + ". "
                    if (dateTheme.dateFormat.contains(DateFormat.SHOW_MONTH_NAME)) dateString += getMonthString(date.getMonth()) + " "
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