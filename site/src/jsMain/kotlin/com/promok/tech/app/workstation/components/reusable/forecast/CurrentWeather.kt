package com.promok.tech.app.workstation.components.reusable.forecast

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(val temperature: Double, val windspeed: Double, val time: String)

