package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

val gray = Color("#edeeed")

@Composable
fun TitleBar(
    desktopApp: DesktopApp,
    offsetX: MutableState<CSSSizeValue<CSSUnit.px>>,
    offsetY: MutableState<CSSSizeValue<CSSUnit.px>>
) {
    val iconSize = 15.px

    var initialClickX by remember { mutableStateOf(0.px) }
    var initialClickY by remember { mutableStateOf(0.px) }

    var dragStartX by remember { mutableStateOf(0.px) }
    var dragStartY by remember { mutableStateOf(0.px) }

    var isDragging by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .thenIf(desktopApp.peak.value) {
                Modifier.boxShadow(blurRadius = 10.px, color = gray)
            }
    ) {
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .onMouseDown { event ->
                    isDragging = true
                    initialClickX = event.clientX.px
                    initialClickY = event.clientY.px
                    dragStartX = offsetX.value
                    dragStartY = offsetY.value

                    desktopApp.maximized.value = false
                }

                .then(
                    if (isDragging) {
                        Modifier
                            .onMouseMove { event ->
                                offsetX.value = dragStartX + (event.clientX.px - initialClickX)
                                offsetY.value = dragStartY + (event.clientY.px - initialClickY)

                                desktopApp.positionX.value = offsetX.value // Save position for minimize function
                                desktopApp.positionY.value = offsetY.value // Save position for minimize function
                            }

                            // Set "DragBox" size. DragBox gets bigger for when the mouse movement is to fast to keep up with the movement of the window
                            .width(2000.px)
                            .height(1000.px)

                            .translate((-500).px, (-500).px) // Shift the TitleBar into the middle of the "DragBox"

                            .onMouseUp {
                                isDragging = false
                            }
                    } else {
                        Modifier
                            .width(desktopApp.width.value)
                            .height(20.px)
                    }
                )
        ) {

        }
        Row(
            modifier = Modifier
                .width(desktopApp.width.value)
                .height(20.px)
                .backgroundColor(gray)
                .color(Color.black)
                .fontWeight(FontWeight.ExtraBlack)
                .borderRadius(topRight = 5.px, topLeft = 5.px),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WindowControl(desktopApp, iconSize)

            Box(
                modifier = Modifier
                    .translateX((desktopApp.width.value / 2) - (iconSize * 3 + 16.px))
            ) {
                Text(desktopApp.name)
            }
        }
    }
}