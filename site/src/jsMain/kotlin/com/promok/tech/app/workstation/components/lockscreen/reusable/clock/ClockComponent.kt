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

class ClockComponent(private val clockTheme: ClockTheme) : Components {
    private var clock: Clock = Clock(this.clockTheme.clockFormat)

    @Composable
    override fun render() {
        var time: String by remember { mutableStateOf("") }

        /**
         * Updates the time every second
         */
        LaunchedEffect(Unit) {
            while (true) {
                time = clock.getTime()
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