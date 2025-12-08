package com.promok.tech.themes

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

object DarkTheme : GlobalTheme {
    override val backgroundColor: CSSColorValue = rgb(18, 18, 18)
    override val textColor: CSSColorValue = rgb(255, 255, 255)
    override val secondaryTextColor: CSSColorValue = rgb(52, 174, 235)
    override val primaryColor: CSSColorValue = rgb(187, 134, 252)
    override val secondaryColor: CSSColorValue = rgb(3, 218, 197)
}