package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProfilePage(desktopApp: DesktopApp) {
    Box(
        modifier = Modifier
            .height(desktopApp.height.value)
            .zIndex(desktopApp.zIndex.value)
    ) {
        Text("Profile")
    }
}