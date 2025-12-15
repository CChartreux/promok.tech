package com.promok.tech.app.workstation.components.reusable.date

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

class DateComponent(val dateTheme: DateTheme) : Components {
    private val date = Date(dateTheme.dateFormat)

    @Composable
    override fun render() {
        var dateString: String by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                dateString = date.getDate()

                delay(60000) // Fetch every minute
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