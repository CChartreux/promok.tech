package com.promok.tech.old.components.window

import androidx.compose.runtime.*
import com.promok.tech.old.components.desktop.DesktopApp
import com.promok.tech.old.components.theme.AppTheme
import com.promok.tech.old.services.DesktopService
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
    desktopApp: com.promok.tech.old.components.desktop.DesktopApp,
    offsetX: MutableState<CSSSizeValue<CSSUnit.px>>,
    offsetY: MutableState<CSSSizeValue<CSSUnit.px>>
) {
    var initialClickX by remember { mutableStateOf(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position) }
    var initialClickY by remember { mutableStateOf(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position) }
    var dragStartX by remember { mutableStateOf(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position) }
    var dragStartY by remember { mutableStateOf(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position) }
    var isDragging by remember { mutableStateOf(false) }

    // Add a global mouse up listener to handle drag release outside the window
    DisposableEffect(isDragging) {
        if (isDragging) {
            _root_ide_package_.com.promok.tech.old.services.DesktopService.currentlyDraggingApp = desktopApp

            val onGlobalMouseUp = { _: Any ->
                isDragging = false
                _root_ide_package_.com.promok.tech.old.services.DesktopService.currentlyDraggingApp = null
                // Now that dragging is done, bring to front
                _root_ide_package_.com.promok.tech.old.services.DesktopService.bringToFront(desktopApp)
            }

            // Add global event listener
            kotlinx.browser.window.addEventListener("mouseup", onGlobalMouseUp)

            // Cleanup
            onDispose {
                kotlinx.browser.window.removeEventListener("mouseup", onGlobalMouseUp)
                _root_ide_package_.com.promok.tech.old.services.DesktopService.currentlyDraggingApp = null
            }
        } else {
            onDispose { }
        }
    }

    Box(
        modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
            .thenIf(desktopApp.isPeeking.value) {
                Modifier.boxShadow(blurRadius = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.windowShadowBlur, color = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Common.shadow)
            }
    ) {
        // This is the invisible drag handle that covers the entire title bar
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .width(desktopApp.width.value)
                .height(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.titleBarHeight)
                .onMouseDown { event ->
                    isDragging = true
                    initialClickX = event.clientX.px
                    initialClickY = event.clientY.px
                    dragStartX = offsetX.value
                    dragStartY = offsetY.value

                    // Only bring to front if not already dragging
                    if (!isDragging) {
                        _root_ide_package_.com.promok.tech.old.services.DesktopService.bringToFront(desktopApp)
                    }
                    event.stopPropagation() // Prevent event from propagating to other windows
                }
                .onDoubleClick {
                    _root_ide_package_.com.promok.tech.old.services.DesktopService.maximizeApp(desktopApp)
                }
                .then(
                    if (isDragging) {
                        Modifier
                            .onMouseMove { event ->
                                if (desktopApp.isMaximized.value) {
                                    _root_ide_package_.com.promok.tech.old.services.DesktopService.maximizeApp(desktopApp)
                                }

                                offsetX.value = dragStartX + (event.clientX.px - initialClickX)
                                offsetY.value = dragStartY + (event.clientY.px - initialClickY)
                                desktopApp.positionX.value = offsetX.value
                                desktopApp.positionY.value = offsetY.value
                                event.stopPropagation() // Prevent event from propagating to other windows
                            }
                            .width(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.dragBoxWidth)
                            .height(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.dragBoxHeight)
                            .translate(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.dragBoxTranslation, _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.dragBoxTranslation)
                    } else {
                        Modifier
                    }
                )
        )

        // This is the visible title bar content
        Row(
            modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
                .width(desktopApp.width.value)
                .height(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.titleBarHeight)
                .backgroundColor(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.windowTitleBar)
                .color(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.textPrimary)
                .fontWeight(FontWeight.ExtraBlack)
                .borderRadius(
                    topRight = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Borders.windowRadiusTop,
                    topLeft = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Borders.windowRadiusTop
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            _root_ide_package_.com.promok.tech.old.components.window.WindowControl(
                desktopApp,
                _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.windowControlIconSize
            )

            Box(
                modifier = Modifier
                    .translateX((desktopApp.width.value / 2) - (_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.windowControlIconSize * 3 + 16.px))
            ) {
                Text(desktopApp.name)
            }
        }
    }
}