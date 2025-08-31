package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import org.jetbrains.compose.web.css.*

@Composable
fun DesktopAppPage(desktopApp: DesktopApp, content: @Composable () -> Unit) {
    var initialClickX by remember { mutableStateOf(0.px) }
    var initialClickY by remember { mutableStateOf(0.px) }

    var dragStartX by remember { mutableStateOf(0.px) }
    var dragStartY by remember { mutableStateOf(0.px) }

    var isDragging by remember { mutableStateOf(false) }

    var offsetX by remember { mutableStateOf(0.px) }
    var offsetY by remember { mutableStateOf(0.px) }

    Box(
        modifier = Modifier
            .position(Position.Absolute)
            .onMouseDown { event ->
                isDragging = true
                initialClickX = event.clientX.px
                initialClickY = event.clientY.px
                dragStartX = offsetX
                dragStartY = offsetY
            }

            .thenIf(isDragging) {
                Modifier
                    .onMouseMove { event ->
                        offsetX = dragStartX + (event.clientX.px - initialClickX)
                        offsetY = dragStartY + (event.clientY.px - initialClickY)
                    }

                    .size(1000.px)

                    .onMouseUp { isDragging = false }
            }
            .translateX(offsetX)

    ) {
        Box(
            modifier = Modifier
                .translateY(offsetY)
        ) {
            Column {
                DesktopAppControlBar(desktopApp, 1000.px)

                Box(
                    modifier = Modifier
                        .height(600.px)
                        .backgroundColor(Color.white)
                ) {
                    content()
                }
            }
        }
    }
}