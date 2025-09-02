package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun AppWindow(desktopApp: DesktopApp, content: @Composable () -> Unit) {
    val appWidth = 1000.px
    val appHeight = 600.px

    val offsetX = remember { mutableStateOf(0.px) }
    var offsetY = remember { mutableStateOf(0.px) }

    Box(
        modifier = Modifier
            .height(appHeight)
            .width(appWidth)
            .translate(offsetX.value, offsetY.value)
            .zIndex(desktopApp.zIndex.value)

            .onMouseDown {
                desktopApp.clicked.value = true

                console.log(desktopApp.name + " got clicked and has the z-Index of " + desktopApp.zIndex.value)
            }

    ) {
        Column {
            TitleBar(desktopApp, appWidth, offsetX, offsetY)

            Box(
                modifier = Modifier
                    .height(appHeight)
                    .width(appWidth)
                    .backgroundColor(Color.white)
                    //.boxShadow(blurRadius = 6.px, color = Color.whitesmoke)
                    .border(2.px, LineStyle.Solid, color = Color("#edeeed"))

            ) {
                content()
            }
        }
    }
}
