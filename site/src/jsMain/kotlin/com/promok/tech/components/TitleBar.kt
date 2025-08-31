package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

val gray = Color("#edeeed")

@Composable
fun TitleBar(desktopApp: DesktopApp, appWidth: CSSSizeValue<CSSUnit.px>) {
    val iconSize = 15.px

    Box(
        modifier = Modifier
            .width(appWidth)
            .height(20.px)
            .backgroundColor(gray)
            .color(Color.black)
            .fontWeight(FontWeight.ExtraBlack)
            .borderRadius(topRight = 5.px, topLeft = 5.px)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WindowControl(desktopApp, iconSize)

            Box(
                modifier = Modifier
                    .translateX((appWidth / 2) - (iconSize * 3 + 16.px))
            ) {
                Text(desktopApp.name)
            }
        }
    }
}