package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

@Composable
fun BottomApps() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.px),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row {
            AppIcon("favicon.ico")
            AppIcon("favicon.ico")
            AppIcon("favicon.ico")
            AppIcon("favicon.ico")
            AppIcon("favicon.ico")
            AppIcon("favicon.ico")
        }
    }
}
