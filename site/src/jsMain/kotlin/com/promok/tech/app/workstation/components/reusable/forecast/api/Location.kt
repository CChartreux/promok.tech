package com.promok.tech.app.workstation.components.reusable.forecast.api

import com.promok.tech.app.util.Cookies
import com.promok.tech.app.workstation.components.reusable.forecast.api.response.Location
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.hours

class Location {
    private val json = Json { ignoreUnknownKeys = true }
    private val url = "https://ipapi.co/json/"

    // Get user's location by IP
    suspend fun getUserLocation(): Location {
        val lastCityLocation = Cookies.getCookie("last_city_location")
        val lastLatitudeLocation = Cookies.getCookie("last_latitude_location")
        val lastLongitudeLocation = Cookies.getCookie("last_longitude_location")

        if (lastCityLocation != null && lastLatitudeLocation != null && lastLongitudeLocation != null) {
            val tempLatitudeLocation = lastLatitudeLocation.toDoubleOrNull()
            val tempLongitudeLocation = lastLongitudeLocation.toDoubleOrNull()

            if (tempLatitudeLocation != null && tempLongitudeLocation != null) return Location(
                lastCityLocation,
                tempLatitudeLocation,
                tempLongitudeLocation
            )
        }

        val ipapiResponse = window.fetch(url).await()
        val response = ipapiResponse.text().await()

        val location = json.decodeFromString<Location>(response)

        Cookies.set("last_city_location", location.city, 4.hours) // Save cookie for 4 hours
        Cookies.set("last_latitude_location", location.latitude.toString(), 4.hours) // Save cookie for 4 hours
        Cookies.set("last_longitude_location", location.longitude.toString(), 4.hours) // Save cookie for 4 hours

        return location
    }
}