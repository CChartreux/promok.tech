package com.promok.tech.themes

import com.promok.tech.themes.font.FontFamily
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

// Base theme
interface GlobalTheme {
    val backgroundColor: CSSColorValue get() = currentTheme.backgroundColor
    val textColor: CSSColorValue get() = currentTheme.textColor
    val primaryColor: CSSColorValue get() = currentTheme.primaryColor
    val secondaryColor: CSSColorValue get() = currentTheme.secondaryColor

    val fontWeight: FontWeight get() = FontWeight.Normal
    val fontSize: FontSize get() = FontSize.Medium
    val fontFamily: String get() = FontFamily.Inter
}

var currentTheme: GlobalTheme = DarkTheme