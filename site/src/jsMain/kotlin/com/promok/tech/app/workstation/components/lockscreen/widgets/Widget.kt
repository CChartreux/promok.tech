package com.promok.tech.app.workstation.components.lockscreen.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Text

class Widget(val title: String, val seeMoreText: String) {
    @Composable
    fun render(widgetContent: @Composable () -> Unit) {
        Column {
            Box(
                modifier = Modifier
                    .color(WidgetTheme.textColor)
                    .fontSize(WidgetTheme.fontSize)
                    .fontWeight(WidgetTheme.fontWeight)
                    .fontFamily(WidgetTheme.fontFamily)
            ) {
                Text(title)
            }

            widgetContent()

            Box(
                modifier = Modifier
                    .color(WidgetTheme.primaryColor)
                    .fontSize(WidgetTheme.fontSize)
                    .fontWeight(WidgetTheme.fontWeight)

                    .fillMaxWidth()
                    .justifyContent(JustifyContent.Center)
            ) {
                Text(seeMoreText)
            }
        }
    }
}