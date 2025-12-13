package com.promok.tech.app.workstation.components.lockscreen.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Text

object ForecastWidgetComponent : WidgetComponent() {
    override val widget: Widget = Widget("Forecast", "See full forecast")

    @Composable
    override fun widgetContent() {
        Text("Hello World")
    }
}