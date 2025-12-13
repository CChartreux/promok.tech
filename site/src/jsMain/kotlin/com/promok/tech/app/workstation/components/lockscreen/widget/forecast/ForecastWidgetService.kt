package com.promok.tech.app.workstation.components.lockscreen.widget.forecast

import kotlinx.browser.window
import kotlinx.coroutines.await

object ForecastWidgetService {
    suspend fun getWeather(): String {
        val url =
            "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m"

        val response = window.fetch(url).await()
        val text = response.text().await()

        return text
    }
}