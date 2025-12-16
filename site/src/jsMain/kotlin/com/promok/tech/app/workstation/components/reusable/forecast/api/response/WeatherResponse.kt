package com.promok.tech.app.workstation.components.reusable.forecast.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtimeMs: Double? = null,
    val utcOffsetSeconds: Int? = null,
    val timezone: String? = null,
    val timezoneAbbreviation: String? = null,
    @SerialName("current_weather") val currentWeather: CurrentWeather
)

