package com.promok.tech.services

import androidx.compose.runtime.mutableStateOf
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

object DesktopService {
    private val apps = mutableStateOf(
        listOf(
            DesktopApp("Profile", "profile.ico"),
            DesktopApp("Projects", "projects.ico"),
            DesktopApp("Settings", "settings.ico"),
            DesktopApp("Profile", "profile.ico"),
            DesktopApp("Projects", "projects.ico"),
            DesktopApp("Settings", "settings.ico")
        )
    )

    fun getApps(): List<DesktopApp> = apps.value

    fun bringToFront(app: DesktopApp) {
        val updatedApps = apps.value.toMutableList()
        updatedApps.remove(app)
        updatedApps.add(app) // Add to end (highest z-index)
        apps.value = updatedApps

        // Update z-index values
        updatedApps.forEachIndexed { index, desktopApp ->
            desktopApp.zIndex.value = index + 1
        }
    }

    fun openApp(app: DesktopApp) {
        app.isOpened.value = true
        app.isMinimized.value = false
        bringToFront(app)
    }

    fun closeApp(app: DesktopApp) {
        app.isOpened.value = false
    }

    fun maximizeApp(app: DesktopApp) {
        if (!app.isMaximized.value) {
            app.isMaximized.value = !app.isMaximized.value

            app.height.value = window.innerHeight.px
            app.width.value = window.innerWidth.px

            app.positionX.value = AppTheme.Defaults.position
            app.positionY.value = AppTheme.Defaults.position
        } else {
            app.isMaximized.value = !app.isMaximized.value

            app.height.value = AppTheme.Sizes.defaultWindowHeight
            app.width.value = AppTheme.Sizes.defaultWindowWidth
        }
    }

    fun minimizeApp(app: DesktopApp) {
        app.isMinimized.value = !app.isMinimized.value
    }
}