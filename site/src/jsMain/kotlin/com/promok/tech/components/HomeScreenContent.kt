package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

data class DesktopApp(var name: String, var icon: String, var opened: Int)

@Composable
fun Apps() {
    var desktopApps by remember {
        mutableStateOf(
            listOf(
                DesktopApp("profile", "profile.ico", 0),
                DesktopApp("projects", "settings.ico", 0),
                DesktopApp("settings", "settings.ico", 0)
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProfilePage()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.px),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row {
                desktopApps.forEach { app ->
                    AppIcon(app)
                }
            }
        }
    }
}
