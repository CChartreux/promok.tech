package com.promok.tech.components.window

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.services.DesktopService
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
        "window-controls/closeWindowCircle.ico",
        modifier = Modifier
            .size(iconSize)
            .translateX(10.px)
            .onMouseDown { DesktopService.closeApp(desktopApp) }
    )

    if (desktopApp.isResizeable.value) {
        Image(
            "window-controls/maximizeWindowCircle.ico",
            modifier = Modifier
                .size(iconSize)
                .translateX(13.px)
                .onMouseDown { DesktopService.maximizeApp(desktopApp) }
        )

        Image(
            "window-controls/minimizeWindowCircle.ico",
            modifier = Modifier
                .size(iconSize)
                .translateX(16.px)
                .onMouseDown { DesktopService.minimizeApp(desktopApp) }
        )
    } else {
        Image(
            "window-controls/minimizeWindowCircle.ico",
            modifier = Modifier
                .size(iconSize)
                .translateX(13.px)
                .onMouseDown { DesktopService.minimizeApp(desktopApp) }
        )
    }
}