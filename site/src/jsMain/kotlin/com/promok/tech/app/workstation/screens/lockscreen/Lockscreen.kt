package com.promok.tech.app.workstation.screens.lockscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.app.workstation.components.reusable.clock.ClockComponent
import com.promok.tech.app.workstation.components.reusable.clock.ClockFormat
import com.promok.tech.app.workstation.components.reusable.clock.ClockTheme
import com.promok.tech.app.workstation.components.reusable.date.DateComponent
import com.promok.tech.app.workstation.components.reusable.date.DateFormat
import com.promok.tech.app.workstation.components.reusable.date.DateTheme
import com.promok.tech.app.workstation.components.lockscreen.widget.forecast.ForecastWidgetComponent
import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.CSSUrl
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw

class Lockscreen(isWorkstationUnlocked: MutableState<Boolean>) : com.promok.tech.app.workstation.screens.Screen {
    // Member variables
    private val _backgroundImageUrl: MutableState<CSSUrl> =
        mutableStateOf(
            url("https://images.unsplash.com/photo-1633379314203-b6e63901273d?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDI3fHx8ZW58MHx8fHx8")
        )

    override val backgroundImageUrl: State<CSSUrl> get() = _backgroundImageUrl

    // Unlock Screen
    private val unlockscreen: Unlockscreen = Unlockscreen(isWorkstationUnlocked)

    // Clock component
    private val clock = ClockComponent(
        ClockTheme(
            fontSize = currentTheme.titleXXLarge,
            fontFamily = currentTheme.fontFamily,
            fontWeight = currentTheme.regularWeight,
            clockFormat = setOf(
                ClockFormat.SHOW_HOURS,
                ClockFormat.SHOW_MINUTES,
                ClockFormat.TWELVE_HOUR
            )
        )
    )

    private val date: DateComponent =
        DateComponent(
            DateTheme(
                fontSize = currentTheme.titleMedium,
                fontFamily = currentTheme.fontFamily,
                dateFormat = setOf(
                    DateFormat.SHOW_DAY_NAME,
                    DateFormat.SHOW_DAY,
                    DateFormat.SHOW_MONTH_NAME,
                    DateFormat.SHOW_YEAR_ABBREVIATION
                )
            )
        )

    /**
     * Function to render default lockscreen
     * @category Private Composable
     */
    @Composable
    private fun defaultScreen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.vh)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            clock.render()
            date.render()

            Spacer() // Pushes everything below to the bottom

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .justifyContent(JustifyContent.Center)
                    .gap(1.vw)
                    .padding(bottom = 4.vh),
            ) {
                ForecastWidgetComponent.render()
                ForecastWidgetComponent.render()
                ForecastWidgetComponent.render()
                ForecastWidgetComponent.render()
            }

        }
    }

    @Composable
    override fun render() {
        Box(
            modifier = Modifier
                .backgroundImage(_backgroundImageUrl.value)
                .background { repeat(BackgroundRepeat.NoRepeat) }
                .background { size(BackgroundSize.Cover) }
                .background { color(Color.black) }
                .fillMaxSize()
                .overflow(Overflow.Hidden)

                .onDrag { unlockscreen.unlockWorkstation() }
                .onClick { unlockscreen.unlockWorkstation() }
                .onKeyDown { keyEvent ->
                    if (keyEvent.key == "Escape") {
                        unlockscreen.lockWorkstation()
                    }
                }
                .tabIndex(0) // Make the Box focusable to receive key events
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .overflow(Overflow.Hidden)
                    .styleModifier {
                        property("background-color", "rgba(0,0,0,0.4)")
                    }
            ) {
                when {
                    unlockscreen.isWorkstationUnlocking.value -> unlockscreen.render()
                    else -> defaultScreen()
                }
            }
        }
    }
}