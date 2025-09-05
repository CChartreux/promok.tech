package com.promok.tech.services

import androidx.compose.runtime.mutableStateOf
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.registry.AppRegistry
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

object DesktopService {
    val apps = mutableStateOf(
        AppRegistry.getAllAppNames().map { appName ->
            DesktopApp(
                name = appName,
                icon = AppRegistry.getAppIcon(appName)
            )
        }
    )

    // Track the currently dragging app to prevent recomposition issues
    var currentlyDraggingApp: DesktopApp? = null

    fun bringToFront(app: DesktopApp) {
        // Don't update the apps list if we're currently dragging to avoid recomposition
        if (currentlyDraggingApp == app) return

        val updatedApps = apps.value.toMutableList().apply {
            remove(app)
            add(app)
        }
        apps.value = updatedApps

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
        app.isMaximized.value = !app.isMaximized.value

        if (app.isMaximized.value) {
            app.height.value = window.innerHeight.px
            app.width.value = window.innerWidth.px
            app.positionX.value = AppTheme.Defaults.position
            app.positionY.value = AppTheme.Defaults.position
        } else {
            app.height.value = AppTheme.Sizes.defaultWindowHeight
            app.width.value = AppTheme.Sizes.defaultWindowWidth
        }
    }

    fun minimizeApp(app: DesktopApp) {
        app.isMinimized.value = !app.isMinimized.value
    }
}