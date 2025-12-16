package com.promok.tech.app.workstation.components.reusable.forecast.api

import com.promok.tech.app.workstation.components.reusable.forecast.api.response.WeatherResponse
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.json.Json

class Forecast {
    private val json = Json { ignoreUnknownKeys = true }
    private var url: String = ""

    // Get weather for a specific lat/lon
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        url = "https://api.open-meteo.com/v1/forecast?latitude=$lat&longitude=$lon&current_weather=true"

        val openMeteoResponse = window.fetch(url).await()
        val response = openMeteoResponse.text().await()

        return json.decodeFromString<WeatherResponse>(response)
    }
}