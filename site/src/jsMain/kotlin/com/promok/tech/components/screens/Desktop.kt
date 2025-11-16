package com.promok.tech.components.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.interfaces.Screen
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.CSSUrl
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow

class Desktop(private val isWorkstationUnlocked: MutableState<Boolean>) : Screen {
    private var _backgroundImageUrl: MutableState<CSSUrl> =
        mutableStateOf(url("https://wallpapers.com/images/hd/2440x1440-desktop-pc-background-wkvl5uwxyeuanzts.jpg"))

    override val backgroundImageUrl: State<CSSUrl> get() = _backgroundImageUrl

    @Composable
    override fun render() {
        Box(
            modifier = Modifier
                .backgroundImage(_backgroundImageUrl.value)
                .background { repeat(BackgroundRepeat.NoRepeat) }
                .background { size(BackgroundSize.Cover) }
                .fillMaxSize()
                .overflow(Overflow.Hidden)

                .onClick { isWorkstationUnlocked.value = false },
        ) {

        }
    }
}