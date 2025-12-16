package com.promok.tech.app.workstation.components.lockscreen.widget.forecast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.app.workstation.components.Components
import com.promok.tech.app.workstation.components.lockscreen.widget.WidgetComponent
import com.promok.tech.app.workstation.components.reusable.forecast.api.response.CurrentWeather
import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text

object ForecastWidgetComponent : Components {
    private val city = mutableStateOf<String?>(null)

    @Composable
    fun widgetContent() {
        val currentWeather = mutableStateOf<CurrentWeather?>(null)

        LaunchedEffect(Unit) {
            ForecastWidget.getWeather(city, currentWeather) // Get current weather
        }

        Row(
            modifier = Modifier
                .alignItems(AlignItems.Center)
        ) {
            Image(
                "/app-icons/lockscreen/widgets/forecast/day_clear.svg",
                width = 55,
                height = 55,
                alt = "Sunny day icon"
            )

            Row {
                Box(
                    modifier = Modifier
                        .fontSize(currentTheme.titleLarge)
                        .fontWeight(currentTheme.semiBoldWeight)
                ) {
                    Text(currentWeather.value?.temperature.toString())
                }

                Box(
                    modifier = Modifier
                        .fontSize(currentTheme.bodySmall)
                        .fontWeight(currentTheme.regularWeight)

                        .padding(top = 0.2.vh)
                ) {
                    Text("°C")
                }
            }
        }
    }

    @Composable
    override fun render() {
        WidgetComponent(city.value ?: "Unknown", "See full forecast") { widgetContent() }.render() // Create widget
    }
}
