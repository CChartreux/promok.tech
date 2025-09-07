package com.promok.tech.components.window

import androidx.compose.runtime.*
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.services.DesktopService
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

@Composable
fun TitleBar(
    desktopApp: DesktopApp,
    offsetX: MutableState<CSSSizeValue<CSSUnit.px>>,
    offsetY: MutableState<CSSSizeValue<CSSUnit.px>>
) {
    var initialClickX by remember { mutableStateOf(AppTheme.Defaults.position) }
    var initialClickY by remember { mutableStateOf(AppTheme.Defaults.position) }
    var dragStartX by remember { mutableStateOf(AppTheme.Defaults.position) }
    var dragStartY by remember { mutableStateOf(AppTheme.Defaults.position) }
    var isDragging by remember { mutableStateOf(false) }

    // Add a global mouse up listener to handle drag release outside the window
    DisposableEffect(isDragging) {
        if (isDragging) {
            DesktopService.currentlyDraggingApp = desktopApp

            val onGlobalMouseUp = { _: Any ->
                isDragging = false
                DesktopService.currentlyDraggingApp = null
                // Now that dragging is done, bring to front
                DesktopService.bringToFront(desktopApp)
            }

            // Add global event listener
            kotlinx.browser.window.addEventListener("mouseup", onGlobalMouseUp)

            // Cleanup
            onDispose {
                kotlinx.browser.window.removeEventListener("mouseup", onGlobalMouseUp)
                DesktopService.currentlyDraggingApp = null
            }
        } else {
            onDispose { }
        }
    }

    Box(
        modifier = Modifier
            .thenIf(desktopApp.isPeeking.value) {
                Modifier.boxShadow(blurRadius = AppTheme.Sizes.windowShadowBlur, color = AppTheme.Colors.Common.shadow)
            }
    ) {
        // This is the invisible drag handle that covers the entire title bar
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .width(desktopApp.width.value)
                .height(AppTheme.Sizes.titleBarHeight)
                .onMouseDown { event ->
                    isDragging = true
                    initialClickX = event.clientX.px
                    initialClickY = event.clientY.px
                    dragStartX = offsetX.value
                    dragStartY = offsetY.value

                    // Only bring to front if not already dragging
                    if (!isDragging) {
                        DesktopService.bringToFront(desktopApp)
                    }
                    event.stopPropagation() // Prevent event from propagating to other windows
                }
                .onDoubleClick {
                    DesktopService.maximizeApp(desktopApp)
                }
                .then(
                    if (isDragging) {
                        Modifier
                            .onMouseMove { event ->
                                if (desktopApp.isMaximized.value) {
                                    DesktopService.maximizeApp(desktopApp)
                                }

                                offsetX.value = dragStartX + (event.clientX.px - initialClickX)
                                offsetY.value = dragStartY + (event.clientY.px - initialClickY)
                                desktopApp.positionX.value = offsetX.value
                                desktopApp.positionY.value = offsetY.value
                                event.stopPropagation() // Prevent event from propagating to other windows
                            }
                            .width(AppTheme.Sizes.dragBoxWidth)
                            .height(AppTheme.Sizes.dragBoxHeight)
                            .translate(AppTheme.Sizes.dragBoxTranslation, AppTheme.Sizes.dragBoxTranslation)
                    } else {
                        Modifier
                    }
                )
        )

        // This is the visible title bar content
        Row(
            modifier = Modifier
                .width(desktopApp.width.value)
                .height(AppTheme.Sizes.titleBarHeight)
                .backgroundColor(AppTheme.Colors.currentTheme.windowTitleBar)
                .color(AppTheme.Colors.currentTheme.textPrimary)
                .fontWeight(FontWeight.ExtraBlack)
                .borderRadius(
                    topRight = AppTheme.Borders.windowRadiusTop,
                    topLeft = AppTheme.Borders.windowRadiusTop
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WindowControl(desktopApp, AppTheme.Sizes.windowControlIconSize)

            Box(
                modifier = Modifier
                    .translateX((desktopApp.width.value / 2) - (AppTheme.Sizes.windowControlIconSize * 3 + 16.px))
            ) {
                Text(desktopApp.name)
            }
        }
    }
}