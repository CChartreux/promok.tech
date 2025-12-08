package com.promok.tech.app.components.util.clock

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

class Clock(val clockTheme: ClockTheme) : Components {
    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }
        var time by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                date = Date()

                if (clockTheme.clockFormat.contains(ClockFormat.SHOW_ALL)) {
                    time = if (date.getHours() > 12) (date.getHours() - 12).toString().padStart(2, '0')
                    else date.getHours().toString()
                    time +=
                        date.getHours().toString() + ":" + date.getMinutes().toString() + ":" + date.getSeconds()
                            .toString().padStart(2, '0')
                } else {
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_HOURS)) time =
                        if (date.getHours() > 12) (date.getHours() - 12).toString().padStart(2, '0')
                        else date.getHours().toString().padStart(2, '0')
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_MINUTES)) time +=
                        ":" + date.getMinutes().toString().padStart(2, '0')
                    if (clockTheme.clockFormat.contains(ClockFormat.SHOW_SECONDS)) time +=
                        ":" + date.getSeconds().toString().padStart(2, '0')
                }

                delay(1000L) // wait 1 second
            }
        }

        Column(
            modifier = Modifier
                .color(clockTheme.textColor)
                .fontSize(clockTheme.fontSize)
                .fontWeight(clockTheme.fontWeight)
                .fontFamily(clockTheme.fontFamily)
        ) {
            Text(time)
        }
    }
}