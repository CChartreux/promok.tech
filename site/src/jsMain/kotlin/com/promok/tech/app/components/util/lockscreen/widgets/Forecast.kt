package com.promok.tech.app.components.util.lockscreen.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import org.jetbrains.compose.web.dom.Text

object Forecast : Widget {
    override val title: String = "Forecast"
    override val seeMoreText: String = "See full Forecast"

    @Composable
    override fun render() {
        Column(
            modifier = Modifier
                .color(WidgetTheme.textColor)
                .fontSize(WidgetTheme.fontSize)
                .fontWeight(WidgetTheme.fontWeight)
                .fontFamily(WidgetTheme.fontFamily)
        ) {
            Text(title)

            Row(
                modifier = Modifier
                    .color(WidgetTheme.secondaryTextColor)
                    .fontSize(FontSize.Small)
                    .fontWeight(FontWeight.Light)
            ) {
                Text(seeMoreText)
            }
        }
    }
}