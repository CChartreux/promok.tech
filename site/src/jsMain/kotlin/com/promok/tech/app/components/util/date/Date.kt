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
    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }

        LaunchedEffect(Unit) {
            while (true) {
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
            Text(date.toString())
        }
    }
}