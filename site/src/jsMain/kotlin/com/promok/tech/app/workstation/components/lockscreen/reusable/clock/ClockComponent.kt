package com.promok.tech.app.workstation.components.lockscreen.reusable.clock

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

class ClockComponent(clockTheme: ClockTheme) : Components {
    private var _clockTheme = run {
        val newFormats = clockTheme.clockFormat.flatMap { clockFormat ->
            if (clockFormat == ClockFormat.SHOW_ALL) {
                setOf(ClockFormat.SHOW_HOURS, ClockFormat.SHOW_MINUTES, ClockFormat.SHOW_SECONDS)
            } else {
                listOf(clockFormat)
            }
        }.toSet()
        clockTheme.copy(clockFormat = newFormats)
    }

    private var clock: Clock = Clock(_clockTheme)

    @Composable
    override fun render() {
        var time: String by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                time = clock.getTime()

                delay(1000L) // wait 1 second
            }
        }

        Column(
            modifier = Modifier
                .color(_clockTheme.textColor)
                .fontSize(_clockTheme.fontSize)
                .fontWeight(_clockTheme.fontWeight)
                .fontFamily(_clockTheme.fontFamily)
        ) {
            Text(time)
        }
    }
}