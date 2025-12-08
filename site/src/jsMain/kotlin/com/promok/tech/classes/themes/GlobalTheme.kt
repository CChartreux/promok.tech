package com.promok.tech.classes.themes

import com.promok.tech.classes.themes.font.FontFamily
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

// Base theme
open class GlobalTheme(
    val backgroundColor: CSSColorValue,
    val textColor: CSSColorValue,
    val primaryColor: CSSColorValue,
    val secondaryColor: CSSColorValue,

    val fontWeight: FontWeight = FontWeight.Normal,
    val fontSize: FontSize = FontSize.Medium,
    val fontFamily: String = FontFamily.Inter
)

// Light and Dark instances
val LightTheme = GlobalTheme(
    backgroundColor = rgb(255, 255, 255),
    textColor = rgb(0, 0, 0),
    primaryColor = rgb(0, 120, 255),
    secondaryColor = rgb(0, 255, 120)
)

val DarkTheme = GlobalTheme(
    backgroundColor = rgb(18, 18, 18),
    textColor = rgb(255, 255, 255),
    primaryColor = rgb(187, 134, 252),
    secondaryColor = rgb(3, 218, 197),
)

// Toggle variable: true = dark, false = light
var isDarkTheme: Boolean = true

// Current theme based on toggle
val CurrentTheme: GlobalTheme
    get() = if (isDarkTheme) DarkTheme else LightTheme