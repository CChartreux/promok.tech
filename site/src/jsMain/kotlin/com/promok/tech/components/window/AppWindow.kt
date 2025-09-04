package com.promok.tech.components.window

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
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
            .onMouseDown { desktopApp.isClicked.value = true }
    ) {
        Column {
            TitleBar(desktopApp, desktopApp.positionX, desktopApp.positionY)

            Box(
                modifier = Modifier
                    .height(desktopApp.height.value)
                    .width(desktopApp.width.value)
                    .backgroundColor(AppTheme.Colors.white)
                    .border(
                        AppTheme.Sizes.windowBorderWidth,
                        AppTheme.Borders.window,
                        color = AppTheme.Colors.windowGray
                    )
                    .thenIf(desktopApp.isPeeking.value) {
                        Modifier.boxShadow(
                            blurRadius = AppTheme.Sizes.windowShadowBlur,
                            color = AppTheme.Colors.whitesmoke
                        )
                    }
                    .thenIf(desktopApp.isMaximized.value) {
                        Modifier.fillMaxSize()
                    }
            ) {
                content()
            }
        }
    }
}