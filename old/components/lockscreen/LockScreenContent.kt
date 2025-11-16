package com.promok.tech.old.components.lockscreen

import androidx.compose.runtime.*
import com.promok.tech.old.components.theme.AppTheme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun LockScreenContent() {
    var currentTime by remember { mutableStateOf("") }
    var currentDate by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (true) {
            val now = js("new Date()")
            currentTime =
                "${now.getHours().toString().padStart(2, '0')}:${now.getMinutes().toString().padStart(2, '0')}"
            currentDate = "${now.getFullYear()}-${(now.getMonth() + 1).toString().padStart(2, '0')}-${
                now.getDate().toString().padStart(2, '0')
            }"
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.lockScreenTopPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion.fontSize(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.lockScreenTimeFontSize)
                .color(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Specific.lockscreenTextPrimary)
        ) {
            Div { Text(currentTime) }
        }
        Box(
            modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion.fontSize(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.lockScreenDateFontSize)
                .color(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Specific.lockscreenTextSecondary)
        ) {
            Div { Text(currentDate) }
        }
    }
}