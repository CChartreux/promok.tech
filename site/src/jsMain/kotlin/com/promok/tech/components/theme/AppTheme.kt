package com.promok.tech.components.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.*

object AppTheme {
    // Colors
    object Colors {
        val windowGray = Color("#edeeed")
        val white = org.jetbrains.compose.web.css.Color.white
        val black = org.jetbrains.compose.web.css.Color.black
        val whitesmoke = org.jetbrains.compose.web.css.Color.whitesmoke
        val defaultAppBaseColor = Triple(0, 255, 255)

        fun rgbaFromTriple(triple: Triple<Int, Int, Int>, alpha: Float = 1.0f): Color {
            return Color.rgba(triple.first, triple.second, triple.third, alpha)
        }
    }

    // Sizes
    object Sizes {
        val titleBarHeight = 20.px
        val appIconSize = 58.px
        val windowControlIconSize = 15.px
        val circleSize = 12.px
        val defaultWindowWidth = 1000.px
        val defaultWindowHeight = 600.px
        val desktopIconContainerHeight = 70.px
        val desktopIconHoverTranslation = 4.px
        val dragBoxWidth = 2000.px
        val dragBoxHeight = 1000.px
        val dragBoxTranslation = (-500).px
        val taskbarPaddingBottom = 10.px
        val taskbarPaddingHorizontal = 15.px
        val windowBorderWidth = 2.px
        val windowShadowBlur = 10.px
        val unlockMessageFontSize = 200.percent
        val unlockMessagePaddingBottom = 30.px
        val lockScreenTimeFontSize = 600.percent
        val lockScreenDateFontSize = 200.percent
        val lockScreenTopPadding = 170.px
    }

    // Animations
    object Animations {
        val iconHoverDuration = 0.1.s
        val unlockAnimationDuration = 1.s
        val scrollUnlockDelay = 200L // milliseconds
    }

    // Default States
    object Defaults {
        val baseColor: MutableState<Triple<Int, Int, Int>> = mutableStateOf(Colors.defaultAppBaseColor)
        val zIndex = 0
        val position = 0.px
    }

    // Border Styles
    object Borders {
        val window = LineStyle.Solid
        val taskbarRadius = 50.px
        val windowRadiusTop = 5.px
    }

    // Z-index values
    object ZIndex {
        val taskbar = Int.MAX_VALUE
    }

    // Opacity values
    object Opacity {
        val appIconInactive = 0.4f
        val appIconActive = 1.0f
        val taskbarBackground = 0.1f
    }

    // Pointer events
    object PointerEvents {
        val none = "none"
        val auto = "auto"
    }
}