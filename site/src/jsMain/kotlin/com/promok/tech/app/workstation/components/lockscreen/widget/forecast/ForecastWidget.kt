package com.promok.tech.app.workstation.components.lockscreen.widget.forecast

import androidx.compose.runtime.MutableState
import com.promok.tech.app.workstation.components.reusable.forecast.api.Forecast
import com.promok.tech.app.workstation.components.reusable.forecast.api.Location
import com.promok.tech.app.workstation.components.reusable.forecast.api.response.CurrentWeather

object ForecastWidget {
    private val forecastService = Forecast()
    private val locationService = Location()

    suspend fun getWeather(city: MutableState<String?>, currentWeather: MutableState<CurrentWeather?>) {
        val location = locationService.getUserLocation()
        val weatherResponse = forecastService.getWeather(location.latitude, location.longitude)

        city.value = location.city
        currentWeather.value = weatherResponse.currentWeather
    }
}
