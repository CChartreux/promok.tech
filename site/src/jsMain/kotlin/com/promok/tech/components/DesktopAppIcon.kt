package com.promok.tech.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CircleIcon
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun DesktopAppIcon(desktopApp: DesktopApp) {
    var hovered by remember { mutableStateOf(false) }

    val appIconSize = 58.px

    Column(
        modifier = Modifier
            .padding(right = 10.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(70.px)

                .onMouseEnter {
                    hovered = true
                    desktopApp.peak.value = true
                }
                .onMouseLeave {
                    hovered = false
                    desktopApp.peak.value = false
                }

                .onMouseDown {
                    desktopApp.opened.value = true

                    desktopApp.clicked.value = true

                    desktopApp.minimized.value = false
                }


        ) {
            Image(
                desktopApp.icon, modifier = Modifier
                    .size(appIconSize)
                    .styleModifier {
                        property("filter", "drop-shadow(4px 4px 10px rgba(0,0,0,0.5))")
                    }
                    .then(
                        if (hovered) Modifier
                            .animation(
                                iconHoverKeyframesUp.toAnimation(
                                    duration = 0.2.s
                                )
                            )

                            .translateY((-10).px)
                        else Modifier
                            .animation(
                                iconHoverKeyframesDown.toAnimation(
                                    duration = 0.2.s
                                )
                            )

                            .translateY(10.px)
                    )
            )

        }

        AppIconCircle(
            desktopApp.opened.value,
            color = Color.rgba(
                desktopApp.baseColor.value.first,
                desktopApp.baseColor.value.second,
                desktopApp.baseColor.value.third,
                0.8f
            )
        )
    }
}

@Composable
fun AppIconCircle(opened: Boolean, color: Color) {
    val circleSize = 12.px

    Row {
        if (opened) {
            CircleIcon(
                modifier = Modifier
                    .color(color = color)
                    .size(circleSize)
            )

//            Image(
//                "openWindowsCircle.ico",
//                modifier = Modifier
//
//                //.padding(right = 10.px)
//                //.translateX((appIconSize / 2) - (circleSize / 2))
//            )
        }
    }
}