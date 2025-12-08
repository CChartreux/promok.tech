package com.promok.tech.app.components.util.date

import androidx.compose.runtime.*
import com.promok.tech.interfaces.Components
import kotlinx.coroutines.delay

class Date() : Components {
    @Composable
    override fun render() {
        var date by remember { mutableStateOf(Date()) }

        LaunchedEffect(Unit) {
            while (true) {
                delay(1000)
            }
        }
    }
}