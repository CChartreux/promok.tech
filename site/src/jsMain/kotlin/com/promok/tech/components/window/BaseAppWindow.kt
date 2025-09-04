package com.promok.tech.components.window

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

@Composable
fun BaseAppWindow(
    desktopApp: DesktopApp,
    content: @Composable () -> Unit
) {
    AppWindow(desktopApp) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.px)
        ) {
            content()
        }
    }
}