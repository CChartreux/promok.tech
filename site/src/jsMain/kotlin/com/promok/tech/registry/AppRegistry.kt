package com.promok.tech.registry

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.pages.ProfilePage
import com.promok.tech.components.pages.ProjectsPage
import com.promok.tech.components.pages.SettingsPage

object AppRegistry {
    private val appComponents = mapOf<String, @Composable (DesktopApp) -> Unit>(
        "Profile" to { desktopApp -> ProfilePage(desktopApp) },
        "Projects" to { desktopApp -> ProjectsPage(desktopApp) },
        "Settings" to { desktopApp -> SettingsPage(desktopApp) }
    )

    // Icons von icons8.de
    private val appIcons = mapOf(
        "Profile" to "app-icons/profile.ico",
        "Projects" to "app-icons/projects.ico",
        "Settings" to "app-icons/settings.ico"
    )

    fun getAppComponent(appName: String): (@Composable (DesktopApp) -> Unit)? {
        return appComponents[appName]
    }

    fun getAppIcon(appName: String): String {
        return appIcons[appName] ?: "default.ico"
    }

    fun getAllAppNames(): List<String> = appComponents.keys.toList()
}