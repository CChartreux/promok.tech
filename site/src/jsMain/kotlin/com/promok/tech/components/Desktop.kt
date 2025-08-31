package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

data class DesktopApp(
    val name: String,
    val icon: String,
    var opened: MutableState<Int> = mutableStateOf(0)
)

@Composable
fun Desktop() {
    var desktopApps by remember {
        mutableStateOf(
            listOf(
                DesktopApp("Profile", "profile.ico", mutableStateOf(0)),
                DesktopApp("Projects", "settings.ico", mutableStateOf(0)),
                DesktopApp("Settings", "settings.ico", mutableStateOf(0))
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        desktopApps.forEach { app ->
            for (i in 0..app.opened.value - 1) {
                DesktopAppPage(app, { ProfilePage(app) })
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.px),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row {
                desktopApps.forEach { app ->
                    DesktopAppIcon(app)
                }
            }
        }
    }
}
