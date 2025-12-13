package com.promok.tech.app.workstation.components.lockscreen.widget

import androidx.compose.runtime.Composable
import com.promok.tech.app.workstation.components.Components
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text

class WidgetComponent(
    val title: String,
    val seeMoreText: String,
    val content: @Composable () -> Unit
) : Components {
    val widget: Widget = Widget(title, seeMoreText)

    @Composable
    private fun WidgetHeader(title: String) {
        Row(
            modifier = with(widget) {
                Modifier
                    .widgetText()
            }
        ) {
            Row(
                modifier = Modifier.gap(0.8.vh)
            ) {
                Image("/app-icons/lockscreen/widgets/weather.png", width = 20, height = 20)
                Text(title)
            }

            Spacer()


            Row(
                modifier = Modifier
                    .gap(0.3.vh)
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(5.px)
                            .borderRadius(50.percent)
                            .backgroundColor(Colors.White)
                    )
                }
            }
        }
    }

    @Composable
    private fun WidgetFooter(text: String) {
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
            Text(text)
        }
    }

    @Composable
    override fun render() {
        Column(modifier = with(widget) {
            Modifier.widgetContainer()
        }) {
            WidgetHeader(title)
            content()
            Spacer()
            WidgetFooter(seeMoreText)
        }
    }
}