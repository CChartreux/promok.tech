package com.promok.tech.components.window

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.services.DesktopService
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf

@Composable
fun AppWindow(desktopApp: DesktopApp, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .height(desktopApp.height.value)
            .width(desktopApp.width.value)
            .translate(desktopApp.positionX.value, desktopApp.positionY.value)
            .zIndex(desktopApp.zIndex.value)
    ) {
        Column {
            TitleBar(desktopApp, desktopApp.positionX, desktopApp.positionY)

            ContentArea(desktopApp, content)
        }
    }
}

@Composable
private fun ContentArea(desktopApp: DesktopApp, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .height(desktopApp.height.value)
            .width(desktopApp.width.value)
            .backgroundColor(AppTheme.Colors.currentTheme.windowBackground)
            .border(
                AppTheme.Sizes.windowBorderWidth,
                AppTheme.Borders.window,
                color = AppTheme.Colors.currentTheme.windowBorder
            )
            .thenIf(desktopApp.isPeeking.value) {
                Modifier.boxShadow(
                    blurRadius = AppTheme.Sizes.windowShadowBlur,
                    color = AppTheme.Colors.Common.shadow
                )
            }
            .onMouseDown {
                // Only bring to front when clicking on content, not when dragging title bar
                DesktopService.bringToFront(desktopApp)
            }
    ) {
        content()
    }
}