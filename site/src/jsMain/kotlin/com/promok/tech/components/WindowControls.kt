package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onMouseDown
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun WindowControl(desktopApp: DesktopApp, iconSize: CSSSizeValue<CSSUnit.px>) {
    Image(
        "closeWindowCircle.ico", modifier = Modifier
            .size(iconSize)
            .translateX(10.px)
            .onMouseDown { desktopApp.opened.value-- }
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
}