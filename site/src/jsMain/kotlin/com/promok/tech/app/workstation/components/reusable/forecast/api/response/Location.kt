package com.promok.tech.app.workstation.components.reusable.forecast.api.response

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val latitude: Double,
    val longitude: Double
)