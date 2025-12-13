package com.promok.tech.app.workstation.components.lockscreen.widget.forecast

import androidx.compose.runtime.*
import com.promok.tech.app.workstation.components.Components
import com.promok.tech.app.workstation.components.lockscreen.widget.WidgetComponent
import com.promok.tech.app.workstation.components.lockscreen.widget.forecast.ForecastWidgetService.getWeather
import org.jetbrains.compose.web.dom.Text

object ForecastWidgetComponent : Components {
    @Composable
    fun widgetContent() {
        var weather: String by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            weather = getWeather()
        }

        Text(weather)
    }

    @Composable
    override fun render() {
        val widgetComponent = WidgetComponent("Forecast", "See full forecast", { widgetContent() })

        widgetComponent.render()
    }
}