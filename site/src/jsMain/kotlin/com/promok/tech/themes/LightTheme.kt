package com.promok.tech.themes

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

// Light and Dark instances
object LightTheme : GlobalTheme {
    override val backgroundColor: CSSColorValue = rgb(255, 255, 255)
    override val textColor: CSSColorValue = rgb(0, 0, 0)
    override val secondaryTextColor: CSSColorValue = rgb(52, 174, 235)
    override val primaryColor: CSSColorValue = rgb(52, 110, 235)
    override val secondaryColor: CSSColorValue = rgb(0, 255, 120)
}