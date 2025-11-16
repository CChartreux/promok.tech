package com.promok.tech.components.screens.lockscreen

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
import com.varabyte.kobweb.compose.ui.modifiers.onDrag
import com.varabyte.kobweb.compose.ui.modifiers.overflow

class Lockscreen(private val isWorkstationUnlocked: MutableState<Boolean>) : Screen {
    private val _backgroundImageUrl: MutableState<CSSUrl> =
        mutableStateOf(url("https://cdn.pixabay.com/photo/2025/09/19/05/48/mountain-range-9842371_1280.jpg"))
    override val backgroundImageUrl: State<CSSUrl> get() = _backgroundImageUrl

    private val unlockscreen: Unlockscreen = Unlockscreen(isWorkstationUnlocked)


    @Composable
    override fun render() {
        Box(
            modifier = Modifier
                .backgroundImage(_backgroundImageUrl.value)
                .background { repeat(BackgroundRepeat.NoRepeat) }
                .background { size(BackgroundSize.Cover) }
                .fillMaxSize()
                .overflow(Overflow.Hidden)

                .onDrag { unlockscreen.setWorkstationToUnlocking() }
                .onClick { unlockscreen.setWorkstationToUnlocking() },
        ) {
            if (unlockscreen.isWorkstationUnlocking.value) unlockscreen.render()
        }
    }


}