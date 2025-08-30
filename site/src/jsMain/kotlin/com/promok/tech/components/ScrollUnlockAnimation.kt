package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.events.Event
import org.w3c.dom.events.WheelEvent

@Composable
fun ScrollUnlockAnimation(onUnlock: () -> Unit, content: @Composable (playAnimation: Boolean) -> Unit) {
    var playAnimation by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val listener: (Event) -> Unit = { e ->
            val we = e as WheelEvent
            if (we.deltaY > 0) { // negative deltaY means scrolling up
                scope.launch {
                    playAnimation = true
                    delay(200) // match animation duration
                    onUnlock()
                    playAnimation = false

                }
            }
        }

        window.addEventListener("wheel", listener)
    }

    content(playAnimation)
}