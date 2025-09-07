package com.promok.tech.components.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.*

object AppTheme {
    object Colors {
        object DarkMode {
            // Window and UI elements
            val windowTitleBar = Color("#131313")
            val windowBackground = Color("#2d2d30")
            val windowBorder = Color("#3e3e42")

            // Text colors
            val textPrimary = org.jetbrains.compose.web.css.Color.white
            val textSecondary = Color("#cccccc")
            val textInverted = org.jetbrains.compose.web.css.Color.black

            // Background and surface colors
            val backgroundPrimary = Color("#1e1e1e")
            val backgroundSecondary = Color("#252526")
            val surface = Color("#2d2d30")

            // Interactive elements
            val buttonPrimary = Color("#007acc")
            val buttonHover = Color("#1c97ea")
            val buttonDisabled = Color("#3e3e42")

            // Accent and highlight colors
            val accentColor = Triple(0, 255, 255)
            val highlight = Color("#007acc")
            val success = Color("#4ec9b0")
            val warning = Color("#ce9178")
            val error = Color("#f44747")

            // Taskbar and system colors
            val taskbarBackground = Color("#333333")
            val desktopBackground = Color("#1e1e1e")
        }

        object LightMode {
            // Window and UI elements
            val windowTitleBar = Color("#f5f7f9") // Soft blue-gray
            val windowBackground = Color("#fafafa") // Very light off-white
            val windowBorder = Color("#e1e5e9") // Soft gray border

            // Text colors
            val textPrimary = Color("#2d3748") // Soft near-black for better readability
            val textSecondary = Color("#718096") // Medium gray for secondary text
            val textInverted = Color("#ffffff") // White for text on dark backgrounds

            // Background and surface colors
            val backgroundPrimary = Color("#f8fafc") // Very light blue-gray
            val backgroundSecondary = Color("#f1f5f9") // Slightly darker blue-gray
            val surface = Color("#ffffff") // White for surfaces that need to stand out

            // Interactive elements
            val buttonPrimary = Color("#3b82f6") // Softer blue
            val buttonHover = Color("#2563eb") // Slightly darker blue
            val buttonDisabled = Color("#cbd5e1") // Light gray

            // Accent and highlight colors
            val accentColor = Triple(59, 130, 246) // Matching buttonPrimary as RGB triple
            val highlight = Color("#3b82f6") // Matching buttonPrimary
            val success = Color("#10b981") // Softer green
            val warning = Color("#f59e0b") // Amber
            val error = Color("#ef4444") // Softer red

            // Taskbar and system colors
            val taskbarBackground = Color("#e2e8f0") // Light blue-gray
            val desktopBackground = Color("#f1f5f9") // Very light blue-gray

            // Additional colors for better visual hierarchy
            val cardBackground = Color("#ffffff") // White for cards to create contrast
            val subtleBorder = Color("#e2e8f0") // Very light border
            val focusRing = Color("#93c5fd") // Soft blue focus indicator

            // New subtle background variations
            val subtleBackground = Color("#f8fafc") // Very light background
            val elevatedSurface = Color("#ffffff") // For elevated components
        }

        // Common colors (used in both modes)
        object Common {
            val transparent = Color.rgba(0, 0, 0, 0)
            val shadow = Color.rgba(0, 0, 0, 0.3f)
            val overlay = Color.rgba(0, 0, 0, 0.5f)
        }

        object Specific {
            val lockscreenTextPrimary = org.jetbrains.compose.web.css.Color.white
            val lockscreenTextSecondary = Color("#cccccc")
        }

        // Current theme colors (you can switch between DarkMode and LightMode)
        val currentTheme = DarkMode // or LightMode based on user preference

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
        val baseColor: MutableState<Triple<Int, Int, Int>> = mutableStateOf(Colors.currentTheme.accentColor)
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