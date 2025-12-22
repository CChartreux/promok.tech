package com.promok.tech.app.workstation.components.lockscreen.widget

import androidx.compose.runtime.Composable
import com.promok.tech.app.workstation.components.Components
import com.promok.tech.app.workstation.components.lockscreen.widget.WidgetTheme.widget
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text

class WidgetComponent(
        private val title: String,
        private val seeMoreText: String,
        private val widgetContent: @Composable () -> Unit,
) : Components {

    @Composable
    private fun WidgetHeader() {
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fontSize(WidgetTheme.fontSize)
                    .fontWeight(WidgetTheme.fontWeight),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title)

            Spacer()

            Row(modifier = Modifier.gap(0.3.vh)) {
                repeat(3) {
                    Box(
                            modifier = Modifier
                                .size(4.px)
                                .borderRadius(50.percent)
                                .backgroundColor(Colors.White)
                    )
                }
            }
        }
    }

    @Composable
    private fun WidgetFooter() {
        Column(
                modifier = Modifier
                    .color(WidgetTheme.primaryColor)
                    .fontSize(WidgetTheme.subtitleFontSize)
                    .fontWeight(WidgetTheme.subtitleFontWeight)
                    .fontFamily(WidgetTheme.fontFamily)
                    .fillMaxWidth()
                    .padding(bottom = 1.vh),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(seeMoreText)
        }
    }

    @Composable
    override fun render() {
        Column(
                modifier = Modifier
                    .widget()
                    .padding(top = 1.vh, bottom = 1.vh),
        ) {
            WidgetHeader()

            Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.vh, bottom = 1.vh),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                widgetContent()
                Spacer()
                WidgetFooter()
            }
        }
    }
}
