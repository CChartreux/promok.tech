package com.promok.tech.old.services

import androidx.compose.runtime.mutableStateOf
import com.promok.tech.old.components.desktop.DesktopApp
import com.promok.tech.old.components.theme.AppTheme
import com.promok.tech.old.registry.AppRegistry
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

object DesktopService {
    val apps = mutableStateOf(
        _root_ide_package_.com.promok.tech.old.registry.AppRegistry.getAllAppNames().map { appName ->
            _root_ide_package_.com.promok.tech.old.components.desktop.DesktopApp(
                name = appName,
                icon = _root_ide_package_.com.promok.tech.old.registry.AppRegistry.getAppIcon(appName),
                baseColor = mutableStateOf(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.currentTheme.accentColor)
            )
        }
    )

    // Track the currently dragging app to prevent recomposition issues
    var currentlyDraggingApp: com.promok.tech.old.components.desktop.DesktopApp? = null

    fun bringToFront(app: com.promok.tech.old.components.desktop.DesktopApp) {
        // If we're currently dragging this app, don't update its z-index
        if (currentlyDraggingApp == app) {
            // Only update other apps' z-indices
            apps.value.forEach { otherApp ->
                if (otherApp != app && otherApp.zIndex.value >= app.zIndex.value) {
                    otherApp.zIndex.value = otherApp.zIndex.value - 1
                }
            }
            return
        }

        // Normal behavior for non-dragged apps
        val updatedApps = apps.value.toMutableList().apply {
            _root_ide_package_.kotlin.collections.MutableList.remove(app)
            _root_ide_package_.kotlin.collections.MutableList.add(app)
        }
        apps.value = updatedApps

        updatedApps.forEachIndexed { index, desktopApp ->
            desktopApp.zIndex.value = index + 1
        }
    }

    fun openApp(app: com.promok.tech.old.components.desktop.DesktopApp) {
        app.isOpened.value = true
        app.isMinimized.value = false
        bringToFront(app)
    }

    fun closeApp(app: com.promok.tech.old.components.desktop.DesktopApp) {
        app.isOpened.value = false
    }

    fun maximizeApp(app: com.promok.tech.old.components.desktop.DesktopApp) {
        app.isMaximized.value = !app.isMaximized.value

        if (app.isMaximized.value) {
            app.height.value = window.innerHeight.px
            app.width.value = window.innerWidth.px
            app.positionX.value = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position
            app.positionY.value = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Defaults.position
        } else {
            app.height.value = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.defaultWindowHeight
            app.width.value = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.defaultWindowWidth
        }
    }

    fun minimizeApp(app: com.promok.tech.old.components.desktop.DesktopApp) {
        app.isMinimized.value = !app.isMinimized.value
    }
}