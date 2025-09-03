package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

data class DesktopApp(
    val name: String,
    val icon: String,
    var baseColor: MutableState<Triple<Int, Int, Int>> = mutableStateOf(Triple(0, 255, 255)), // store RGB only,
    var opened: MutableState<Boolean> = mutableStateOf(false),
    var maximized: MutableState<Boolean> = mutableStateOf(false),
    var minimized: MutableState<Boolean> = mutableStateOf(false),
    var clicked: MutableState<Boolean> = mutableStateOf(true),
    var zIndex: MutableState<Int> = mutableStateOf(0),
    var height: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    var width: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    var positionX: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    var positionY: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    var peak: MutableState<Boolean> = mutableStateOf(false),
    var oldZIndex: MutableState<Int> = mutableStateOf(0)
)

@Composable
fun Desktop() {
    var topZ by remember { mutableStateOf(1) }

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
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Render the app windows and update dynamically
            desktopApps.forEach { desktopApp ->
                if (desktopApp.opened.value) {
                    if (desktopApp.peak.value) {
                        // store old zIndex if not already stored
                        if (desktopApp.oldZIndex.value == 0) {
                            desktopApp.oldZIndex.value = desktopApp.zIndex.value
                        }
                        desktopApp.zIndex.value = ++topZ
                    } else {
                        if (desktopApp.oldZIndex.value != 0) {
                            desktopApp.zIndex.value = desktopApp.oldZIndex.value
                            desktopApp.oldZIndex.value = 0
                        }
                    }

                    if (desktopApp.clicked.value) {
                        desktopApp.oldZIndex.value = 0
                        desktopApp.zIndex.value = ++topZ
                        desktopApp.clicked.value = false
                    }

                    if (!desktopApp.minimized.value) {
                        AppWindow(desktopApp) { ProfilePage(desktopApp) }
                    }
                }
            }


        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.px)
                .zIndex(Int.MAX_VALUE)
                .styleModifier { property("pointer-events", "none") }, // ignore hits
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row(
                modifier = Modifier
                    .borderRadius(50.px)
                    .padding(bottom = 10.px, left = 15.px, right = 5.px)
                    .backgroundColor(
                        color = Color.rgba(
                            desktopApps[0].baseColor.value.first,
                            desktopApps[0].baseColor.value.second,
                            desktopApps[0].baseColor.value.third,
                            0.1f
                        )
                    )
                    .styleModifier { property("pointer-events", "auto") } // icons clickable
            ) {
                desktopApps.forEach { app ->
                    DesktopAppIcon(app)
                }
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