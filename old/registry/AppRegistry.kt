package com.promok.tech.old.registry

import androidx.compose.runtime.Composable
import com.promok.tech.old.components.desktop.DesktopApp
import com.promok.tech.old.components.pages.ProfilePage
import com.promok.tech.old.components.pages.ProjectsPage
import com.promok.tech.old.components.pages.SettingsPage

object AppRegistry {
    private val appComponents = mapOf<String, @Composable (com.promok.tech.old.components.desktop.DesktopApp) -> Unit>(
        "Profile" to { desktopApp -> _root_ide_package_.com.promok.tech.old.components.pages.ProfilePage(desktopApp) },
        "Projects" to { desktopApp -> _root_ide_package_.com.promok.tech.old.components.pages.ProjectsPage(desktopApp) },
        "Settings" to { desktopApp -> _root_ide_package_.com.promok.tech.old.components.pages.SettingsPage(desktopApp) }
    )

    // Icons von icons8.de
    private val appIcons = mapOf(
        "Profile" to "app-icons/profile.ico",
        "Projects" to "app-icons/projects.ico",
        "Settings" to "app-icons/settings.ico"
    )

    fun getAppComponent(appName: String): (@Composable (com.promok.tech.old.components.desktop.DesktopApp) -> Unit)? {
        return appComponents[appName]
    }

    fun getAppIcon(appName: String): String {
        return appIcons[appName] ?: "default.ico"
    }

    fun getAllAppNames(): List<String> = appComponents.keys.toList()
}