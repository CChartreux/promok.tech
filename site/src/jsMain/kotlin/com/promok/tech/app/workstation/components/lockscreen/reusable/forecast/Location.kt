package com.promok.tech.app.workstation.components.lockscreen.reusable.forecast

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val latitude: Double,
    val longitude: Double
)