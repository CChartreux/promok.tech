package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun LockScreenContent() {
    var currentTime by remember { mutableStateOf("") }
    var currentDate by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (true) {
            val now = js("new Date()")
            currentTime =
                "${now.getHours().toString().padStart(2, '0')}:${now.getMinutes().toString().padStart(2, '0')}"
            currentDate = "${now.getFullYear()}-${(now.getMonth() + 1).toString().padStart(2, '0')}-${
                now.getDate().toString().padStart(2, '0')
            }"
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 170.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fontSize(600.percent)) {
            Div { Text(currentTime) }
        }
        Box(modifier = Modifier.fontSize(200.percent)) {
            Div { Text(currentDate) }
        }


    }
}