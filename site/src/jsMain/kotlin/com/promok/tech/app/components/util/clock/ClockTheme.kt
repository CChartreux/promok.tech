package com.promok.tech.app.components.util.clock

import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

data class ClockTheme(
    var fontSize: FontSize = currentTheme.fontSize,
    var fontWeight: FontWeight = currentTheme.fontWeight,
    var fontColor: CSSColorValue = currentTheme.textColor,
    var fontFamily: String = currentTheme.fontFamily,
    var clockFormat: Set<ClockFormat> = setOf(ClockFormat.TWENTY_FOUR_HOUR, ClockFormat.SHOW_ALL),
)