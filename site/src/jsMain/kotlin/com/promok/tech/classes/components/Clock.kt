package com.promok.tech.classes.components

import androidx.compose.runtime.*
import com.promok.tech.classes.themes.ClockTheme
import com.promok.tech.interfaces.Components
import com.varabyte.kobweb.compose.css.fontWeight
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class Clock(val clockTheme: ClockTheme) : Components {
    @OptIn(ExperimentalTime::class)
    @Composable
    override fun render() {
        var time by remember { mutableStateOf(Clock.System.now().toString()) }

        LaunchedEffect(Unit) {
            while (true) {
                time = Clock.System.now().toString()
                delay(1000L) // wait 1 second
            }
        }

        Span(
            {
                style {
                    color(clockTheme.fontColor)
                    fontSize(clockTheme.fontSize)
                    fontWeight(clockTheme.fontWeight)
                }
            },
        ) {
            Text(time.substring(time.lastIndexOf("T") + 1, time.lastIndexOf("Z") - 4))
        }
    }
}