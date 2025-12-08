package com.promok.tech.classes.workstation.screens.lockscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.classes.ClockFormat
import com.promok.tech.classes.components.Clock
import com.promok.tech.classes.themes.ClockTheme
import com.promok.tech.classes.themes.font.FontFamily
import com.promok.tech.classes.themes.font.helper.Massive
import com.promok.tech.interfaces.Screen
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.CSSUrl
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.Color
import kotlin.time.ExperimentalTime

class Lockscreen(private val isWorkstationUnlocked: MutableState<Boolean>) : Screen {
    private val _backgroundImageUrl: MutableState<CSSUrl> =
        mutableStateOf(url("https://images.unsplash.com/photo-1633379314203-b6e63901273d?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDI3fHx8ZW58MHx8fHx8"))
    override val backgroundImageUrl: State<CSSUrl> get() = _backgroundImageUrl
    private val unlockscreen: Unlockscreen = Unlockscreen(isWorkstationUnlocked)
    private val clockTheme: ClockTheme = ClockTheme(
        fontSize = FontSize.Massive,
        fontFamily = FontFamily.ADLaM_Display,
        clockFormat = setOf(ClockFormat.SHOW_HOURS, ClockFormat.SHOW_MINUTES)
    )
    private val clock: Clock = Clock(clockTheme)

    @OptIn(ExperimentalTime::class)
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
                if (unlockscreen.isWorkstationUnlocking.value) unlockscreen.render()
                else clock.render()
            }
        }

    }
}