package com.promok.tech.old.components.window

import androidx.compose.runtime.Composable
import com.promok.tech.old.components.desktop.DesktopApp
import com.promok.tech.old.components.theme.AppTheme
import com.promok.tech.old.services.DesktopService
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf

@Composable
fun AppWindow(desktopApp: com.promok.tech.old.components.desktop.DesktopApp, content: @Composable () -> Unit) {
    Box(
        modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
            .height(desktopApp.height.value)
            .width(desktopApp.width.value)
            .translate(desktopApp.positionX.value, desktopApp.positionY.value)
            .zIndex(desktopApp.zIndex.value)
    ) {
        Column {
            _root_ide_package_.com.promok.tech.old.components.window.TitleBar(
                desktopApp,
                desktopApp.positionX,
                desktopApp.positionY
            )

            _root_ide_package_.com.promok.tech.old.components.window.ContentArea(desktopApp, content)
        }
    }
}

@Composable
private fun ContentArea(desktopApp: com.promok.tech.old.components.desktop.DesktopApp, content: @Composable () -> Unit) {
    Box(
        modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
            .height(desktopApp.height.value)
            .width(desktopApp.width.value)
            .backgroundColor(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.windowBackground)
            .border(
                _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.windowBorderWidth,
                _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Borders.window,
                color = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.windowBorder
            )
            .thenIf(desktopApp.isPeeking.value) {
                Modifier.boxShadow(
                    blurRadius = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.windowShadowBlur,
                    color = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Common.shadow
                )
            }
            .onMouseDown {
                // Only bring to front when clicking on content, not when dragging title bar
                _root_ide_package_.com.promok.tech.old.services.DesktopService.bringToFront(desktopApp)
            }
    ) {
        content()
    }
}