package com.promok.tech.components.animations

import androidx.compose.runtime.*
import com.promok.tech.components.theme.AppTheme
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
                    delay(AppTheme.Animations.scrollUnlockDelay) // match animation duration
                    onUnlock()
                    playAnimation = false
                }
            }
        }

        window.addEventListener("wheel", listener)
    }

    content(playAnimation)
}