package com.promok.tech.classes.components

import androidx.compose.runtime.*
import com.promok.tech.classes.ClockFormat
import com.promok.tech.classes.themes.ClockTheme
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

class Clock(val clockTheme: ClockTheme) : Components {
    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }
        var time by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                date = Date()

                if (clockTheme.clockFormat.contains(ClockFormat.SHOW_ALL)) time =
                    date.getHours().toString() + ":" + date.getMinutes().toString() + ":" + date.getSeconds().toString()
                else {
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_HOURS)) time =
                        date.getHours().toString()
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_MINUTES)) time +=
                        ":" + date.getMinutes().toString()
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_SECONDS)) time +=
                        ":" + date.getSeconds().toString()
                }

                delay(1000L) // wait 1 second
            }
        }

        Column(
            modifier = Modifier
                .color(clockTheme.fontColor)
                .fontSize(clockTheme.fontSize)
                .fontWeight(clockTheme.fontWeight)
                .fontFamily(clockTheme.fontFamily)
        ) {
            Text(time)
        }
    }
}