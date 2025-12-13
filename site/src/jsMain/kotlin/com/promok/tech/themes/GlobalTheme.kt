package com.promok.tech.themes

import com.promok.tech.themes.font.FontFamily
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

// Base theme
interface GlobalTheme {
    val backgroundColor: CSSColorValue get() = currentTheme.backgroundColor
    val textColor: CSSColorValue get() = currentTheme.textColor
    val secondaryTextColor: CSSColorValue get() = currentTheme.secondaryTextColor
    val primaryColor: CSSColorValue get() = currentTheme.primaryColor
    val secondaryColor: CSSColorValue get() = currentTheme.secondaryColor

    // Primary body text
    val bodyExtraSmall: FontSize get() = FontSize.XSmall    // small notes, metadata
    val bodySmall: FontSize get() = FontSize.Small          // secondary body text
    val bodyMedium: FontSize get() = FontSize.Medium        // standard body text
    val bodyLarge: FontSize get() = FontSize.Large          // emphasized body text

    // Headings / Titles
    val titleLarge: FontSize get() = FontSize.XXLarge       // section heading
    val titleMedium: FontSize get() = FontSize.XLarge       // subsection heading
    val titleSmall: FontSize get() = FontSize.Large         // minor heading

    // Supporting text
    val subtitle: FontSize get() = FontSize.Large           // subtitles under headings
    val caption: FontSize get() = FontSize.Small           // captions for images or figures
    val label: FontSize get() = FontSize.XSmall            // button labels, small tags

    // Font weight presets
    val thinWeight: FontWeight get() = FontWeight.Thin
    val extraLightWeight: FontWeight get() = FontWeight.ExtraLight
    val lightWeight: FontWeight get() = FontWeight.Light
    val regularWeight: FontWeight get() = FontWeight.Normal
    val mediumWeight: FontWeight get() = FontWeight.Medium
    val semiBoldWeight: FontWeight get() = FontWeight.SemiBold
    val boldWeight: FontWeight get() = FontWeight.Bold
    val extraBoldWeight: FontWeight get() = FontWeight.ExtraBold
    val blackWeight: FontWeight get() = FontWeight.Black

    val fontFamily: String get() = FontFamily.Inter
}

var currentTheme: GlobalTheme = DarkTheme