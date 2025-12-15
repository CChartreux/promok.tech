package com.promok.tech.app.workstation.components.reusable.forecast

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.json.Json

class Forecast {
    private val json = Json { ignoreUnknownKeys = true }

    // Get user's location by IP
    suspend fun getUserLocation(): Location {
        val url = "https://ipapi.co/json/"
        val response = window.fetch(url).await()
        val text = response.text().await()
        return json.decodeFromString<Location>(text)
    }

    // Get weather for a specific lat/lon
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        val url =
            "https://api.open-meteo.com/v1/forecast?latitude=$lat&longitude=$lon&current_weather=true"
        val response = window.fetch(url).await()
        val text = response.text().await()
        return json.decodeFromString<WeatherResponse>(text)
    }
}

