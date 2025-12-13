package com.promok.tech.app.workstation.components.lockscreen.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Text

object ForecastWidgetComponent : Widget {
    override val title: String = "Forecast"
    override val seeMoreText: String = "See full Forecast"

    @Composable
    override fun render() {
        Column() {
            Box(
                modifier = Modifier
                    .color(WidgetTheme.textColor)
                    .fontSize(WidgetTheme.fontSize)
                    .fontWeight(WidgetTheme.fontWeight)
                    .fontFamily(WidgetTheme.fontFamily)
            ) {
                Text(title)
            }

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