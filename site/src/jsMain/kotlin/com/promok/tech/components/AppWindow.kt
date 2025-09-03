package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun AppWindow(desktopApp: DesktopApp, content: @Composable () -> Unit) {
    desktopApp.width.value = 1000.px
    desktopApp.height.value = 600.px

    var offsetX = remember { mutableStateOf(desktopApp.positionX.value) }
    var offsetY = remember { mutableStateOf(desktopApp.positionY.value) }

    if (desktopApp.maximized.value) {
        desktopApp.height.value = window.innerHeight.px
        desktopApp.width.value = window.innerWidth.px

        offsetX.value = 0.px
        offsetY.value = 0.px
    }

    Box(
        modifier = Modifier
            .height(desktopApp.height.value)
            .width(desktopApp.width.value)

            .translate(offsetX.value, offsetY.value)

            .zIndex(desktopApp.zIndex.value)

            .onMouseDown { desktopApp.clicked.value = true }
    ) {
        Column {
            TitleBar(desktopApp, offsetX, offsetY)

            Box(
                modifier = Modifier
                    .height(desktopApp.height.value)
                    .width(desktopApp.width.value)
                    .backgroundColor(Color.white)
                    //.boxShadow(blurRadius = 6.px, color = Color.whitesmoke)
                    .border(2.px, LineStyle.Solid, color = Color("#edeeed"))

                    .thenIf(desktopApp.peak.value) {
                        Modifier.boxShadow(blurRadius = 10.px, color = Color.whitesmoke)
                    }

                    .thenIf(desktopApp.maximized.value) {
                        Modifier.fillMaxSize()
                    }

            ) {
                content()
            }
        }
    }
}
