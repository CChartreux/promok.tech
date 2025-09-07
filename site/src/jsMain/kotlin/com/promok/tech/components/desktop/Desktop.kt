package com.promok.tech.components.desktop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.components.window.AppWindow
import com.promok.tech.registry.AppRegistry
import com.promok.tech.services.DesktopService
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.div

@Composable
fun Desktop() {
    val desktopApps by DesktopService.apps

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            desktopApps.forEach { app ->
                if (app.isOpened.value && !app.isMinimized.value) {
                    AppWindow(app) {
                        AppRegistry.getAppComponent(app.name)?.invoke(app)
                    }
                }
            }
        }

        Taskbar(desktopApps)
    }
}

@Composable
private fun Taskbar(desktopApps: List<DesktopApp>) {
    Box(
        modifier = Modifier
            .padding(bottom = AppTheme.Sizes.taskbarPaddingBottom)
            .fillMaxSize()
            .zIndex(AppTheme.ZIndex.taskbar)
            .styleModifier { property("pointer-events", AppTheme.PointerEvents.none) },
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row(
            modifier = Modifier
                .borderRadius(AppTheme.Borders.taskbarRadius)
                .padding(
                    left = AppTheme.Sizes.taskbarPaddingHorizontal,
                    right = AppTheme.Sizes.taskbarPaddingHorizontal / 3
                )
                .backgroundColor(
                    color = AppTheme.Colors.rgbaFromTriple(
                        AppTheme.Colors.currentTheme.accentColor,
                        AppTheme.Opacity.taskbarBackground
                    )
                )
                .styleModifier { property("pointer-events", AppTheme.PointerEvents.auto) }
        ) {
            desktopApps.forEach { app ->
                DesktopAppIcon(app)
            }
        }
    }
}