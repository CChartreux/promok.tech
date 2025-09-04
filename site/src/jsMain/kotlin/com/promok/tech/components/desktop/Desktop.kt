package com.promok.tech.components.desktop

import androidx.compose.runtime.*
import com.promok.tech.components.pages.ProfilePage
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.components.window.AppWindow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.div

@Composable
fun Desktop() {
    var topZ by remember { mutableStateOf(1) }

    var desktopApps by remember {
        mutableStateOf(
            listOf(
                DesktopApp("Profile", "profile.ico"),
                DesktopApp("Projects", "settings.ico"),
                DesktopApp("Settings", "settings.ico"),
                DesktopApp("Profile", "profile.ico"),
                DesktopApp("Projects", "settings.ico"),
                DesktopApp("Settings", "settings.ico")
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Render the app windows and update dynamically
            desktopApps.forEach { desktopApp ->
                if (desktopApp.isOpened.value) {
                    if (desktopApp.isPeeking.value) {
                        // store old zIndex if not already stored
                        if (desktopApp.oldZIndex.value == AppTheme.Defaults.zIndex) {
                            desktopApp.oldZIndex.value = desktopApp.zIndex.value
                        }
                        desktopApp.zIndex.value = ++topZ
                    } else {
                        if (desktopApp.oldZIndex.value != AppTheme.Defaults.zIndex) {
                            desktopApp.zIndex.value = desktopApp.oldZIndex.value
                            desktopApp.oldZIndex.value = AppTheme.Defaults.zIndex
                        }
                    }

                    if (desktopApp.isClicked.value) {
                        desktopApp.oldZIndex.value = AppTheme.Defaults.zIndex
                        desktopApp.zIndex.value = ++topZ
                        desktopApp.isClicked.value = false
                    }

                    if (!desktopApp.isMinimized.value) {
                        AppWindow(desktopApp) { ProfilePage(desktopApp) }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = AppTheme.Sizes.taskbarPaddingBottom)
                .zIndex(AppTheme.ZIndex.taskbar)
                .styleModifier { property("pointer-events", AppTheme.PointerEvents.none) },
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row(
                modifier = Modifier
                    .borderRadius(AppTheme.Borders.taskbarRadius)
                    .padding(
                        bottom = AppTheme.Sizes.taskbarPaddingBottom,
                        left = AppTheme.Sizes.taskbarPaddingHorizontal,
                        right = AppTheme.Sizes.taskbarPaddingHorizontal / 3
                    )
                    .backgroundColor(
                        color = AppTheme.Colors.rgbaFromTriple(
                            desktopApps[0].baseColor.value,
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
}