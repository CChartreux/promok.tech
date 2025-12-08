package com.promok.tech.themes

import com.promok.tech.themes.font.FontFamily
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

// Base theme
interface GlobalTheme {
    val backgroundColor: CSSColorValue
    val textColor: CSSColorValue
    val primaryColor: CSSColorValue
    val secondaryColor: CSSColorValue

    val fontWeight: FontWeight get() = FontWeight.Normal
    val fontSize: FontSize get() = FontSize.Medium
    val fontFamily: String get() = FontFamily.Inter
}

var currentTheme: GlobalTheme = DarkTheme