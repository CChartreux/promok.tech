package com.promok.tech.app.components.workstation.screens.lockscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.app.components.util.clock.Clock
import com.promok.tech.app.components.util.clock.ClockFormat
import com.promok.tech.app.components.util.clock.ClockTheme
import com.promok.tech.app.components.util.date.Date
import com.promok.tech.app.components.util.date.DateFormat
import com.promok.tech.app.components.util.date.DateTheme
import com.promok.tech.app.components.util.lockscreen.widgets.Forecast
import com.promok.tech.app.components.workstation.screens.Screen
import com.promok.tech.themes.font.FontFamily
import com.promok.tech.themes.font.helper.Huge
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.CSSUrl
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

class Lockscreen(isWorkstationUnlocked: MutableState<Boolean>) : Screen {
    // Member variables
    private val _backgroundImageUrl: MutableState<CSSUrl> =
        mutableStateOf(url("https://images.unsplash.com/photo-1633379314203-b6e63901273d?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDI3fHx8ZW58MHx8fHx8"))

    override val backgroundImageUrl: State<CSSUrl> get() = _backgroundImageUrl

    // Unlock Screen
    private val unlockscreen: Unlockscreen = Unlockscreen(isWorkstationUnlocked)

    // Clock component
    private val clockTheme: ClockTheme = ClockTheme(
        fontSize = FontSize.Huge,
        fontFamily = FontFamily.Inter,
        fontWeight = FontWeight.Bold,
        clockFormat = setOf(ClockFormat.SHOW_HOURS, ClockFormat.SHOW_MINUTES, ClockFormat.TWELVE_HOUR)
    )

    private val clock: Clock = Clock(clockTheme)


    private val dateTheme: DateTheme = DateTheme(
        fontSize = FontSize.XXLarge,
        fontFamily = FontFamily.Inter,
        dateFormat = setOf(DateFormat.SHOW_DAY_NAME, DateFormat.SHOW_MONTH_NAME, DateFormat.SHOW_YEAR_ABBREVIATION)
    )

    private val date: Date = Date(dateTheme)


    /**
     * Function to render default lockscreen
     * @category Private Composable
     */
    @Composable
    private fun defaultScreen() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding { top(100.px) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            clock.render()
            date.render()
        }

        Row(

        ) {
            Forecast.render()
            Forecast.render()
            Forecast.render()
            Forecast.render()
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