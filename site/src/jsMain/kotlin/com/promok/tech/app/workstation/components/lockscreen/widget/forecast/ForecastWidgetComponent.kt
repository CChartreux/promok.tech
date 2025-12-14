package com.promok.tech.app.workstation.components.lockscreen.widget.forecast

import androidx.compose.runtime.*
import com.promok.tech.app.workstation.components.Components
import com.promok.tech.app.workstation.components.lockscreen.reusable.forecast.CurrentWeather
import com.promok.tech.app.workstation.components.lockscreen.reusable.forecast.Forecast
import com.promok.tech.app.workstation.components.lockscreen.reusable.forecast.Location
import com.promok.tech.app.workstation.components.lockscreen.widget.WidgetComponent
import com.varabyte.kobweb.compose.foundation.layout.Column
import org.jetbrains.compose.web.dom.Text

object ForecastWidgetComponent : Components {

    @Composable
    fun widgetContent() {
        var currentWeather by remember { mutableStateOf<CurrentWeather?>(null) }
        var city by remember { mutableStateOf<String?>(null) }

        LaunchedEffect(Unit) {
            val forecast = Forecast()
            val location: Location = forecast.getUserLocation()
            city = location.city

            val weather = forecast.getWeather(location.latitude, location.longitude)
            currentWeather = weather.currentWeather
        }

        Column {
            if (currentWeather != null && city != null) {
                Text("City: $city")
                Text("Temperature: ${currentWeather!!.temperature} °C")
                Text("Wind: ${currentWeather!!.windspeed} km/h")
            } else {
                Text("Loading weather...")
            }
        }
    }

    @Composable
    override fun render() {
        val widgetComponent =
            WidgetComponent("Forecast", "See full forecast") { widgetContent() }

        widgetComponent.render()
    }
}
