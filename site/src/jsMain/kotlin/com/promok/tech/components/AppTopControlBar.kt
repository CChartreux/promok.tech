package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

val gray = Color("#edeeed")

@Composable
fun AppTopControlBar(appName: String, iconSource: String, appWidth: CSSSizeValue<CSSUnit.px>) {
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
            Image(
                "closeWindowCircle.ico", modifier = Modifier
                    .size(iconSize)
                    .translateX(10.px)
                //.onMouseDown {// Here it should subtract 1 from the opened variable}
            )

            Image(
                "maximizeWindowCircle.ico", modifier = Modifier
                    .size(iconSize)
                    .translateX(13.px)
            )

            Image(
                "minimizeWindowCircle.ico", modifier = Modifier
                    .size(iconSize)
                    .translateX(16.px)
            )

            Box(
                modifier = Modifier
                    .translateX((appWidth / 2) - (iconSize * 3 + 16.px))
            ) {
                Text(appName)
            }
        }
    }
}