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
    var clicked: MutableState<Boolean> = mutableStateOf(true),
    var zIndex: MutableState<Int> = mutableStateOf(0)
)

@Composable
fun Desktop() {
    var topZ by remember { mutableStateOf(0) }

    var desktopApps by remember {
        mutableStateOf(
            listOf(
                DesktopApp("Profile", "profile.ico"),
                DesktopApp("Projects", "settings.ico"),
                DesktopApp("Settings", "settings.ico")
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        desktopApps.forEach { app ->
            if (app.clicked.value) {
                app.zIndex.value = ++topZ
                app.clicked.value = false
            }
            AppWindow(app, { ProfilePage(app) })
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


/*
* for (i in 0..<desktopApps.size) {
            val app = desktopApps[i] // Assign the app to an easily accessible variable

            for (i in 0..<app.windowsOpen.value) { // Go through each window opened by the app
                if (app.clicked.value) { // If app got clicked
                    if (app.zIndex.value == desktopApps.size + app.windowsOpen.value) { // If the window is already in the foreground: do Nothing
                        continue
                    } else {
                        app.zIndex.value = desktopApps.size + app.windowsOpen.value // Put the app in the foreground

                        for (i in 0..<desktopApps.size) { // Go through each app again
                            if (desktopApps[i].clicked.value) { // If the app is the most recent clicked app
                                console.log(desktopApps[i].name + " got skipped")

                                continue // Skip the putting in the background
                            } else {
                                if (desktopApps[i].zIndex.value != 0) {
                                    desktopApps[i].zIndex.value-- // Put the app one more into the background
                                }

                                console.log(desktopApps[i].name + " is in the background")
                            }
                        }

                        app.clicked.value = false // Reset app.clicked
                    }
                }

                AppWindow(app, { ProfilePage(app) })
            }
          }
*
*
* */