package com.promok.tech.old.components.desktop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.promok.tech.old.components.theme.AppTheme
import com.promok.tech.old.components.window.AppWindow
import com.promok.tech.old.registry.AppRegistry
import com.promok.tech.old.services.DesktopService
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.div

@Composable
fun Desktop() {
    val desktopApps by _root_ide_package_.com.promok.tech.old.services.DesktopService.apps

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            desktopApps.forEach { app ->
                if (app.isOpened.value && !app.isMinimized.value) {
                    _root_ide_package_.com.promok.tech.old.components.window.AppWindow(app) {
                        _root_ide_package_.com.promok.tech.old.registry.AppRegistry.getAppComponent(app.name)
                            ?.invoke(app)
                    }
                }
            }
        }

        _root_ide_package_.com.promok.tech.old.components.desktop.Taskbar(desktopApps)
    }
}

@Composable
private fun Taskbar(desktopApps: List<com.promok.tech.old.components.desktop.DesktopApp>) {
    Box(
        modifier = Modifier
            .padding(bottom = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.taskbarPaddingBottom)
            .fillMaxSize()
            .zIndex(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.ZIndex.taskbar)
            .styleModifier { property("pointer-events", _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.PointerEvents.none) },
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row(
            modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
                .borderRadius(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Borders.taskbarRadius)
                .padding(
                    left = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.taskbarPaddingHorizontal,
                    right = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.taskbarPaddingHorizontal / 3
                )
                .backgroundColor(
                    color = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.rgbaFromTriple(
                        _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.accentColor,
                        _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Opacity.taskbarBackground
                    )
                )
                .styleModifier { property("pointer-events", _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.PointerEvents.auto) }
        ) {
            desktopApps.forEach { app ->
                _root_ide_package_.com.promok.tech.old.components.desktop.DesktopAppIcon(app)
            }
        }
    }
}