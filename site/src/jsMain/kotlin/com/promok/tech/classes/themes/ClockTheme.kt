package com.promok.tech.classes.themes

import com.promok.tech.classes.ClockFormat
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

data class ClockTheme(
    var fontSize: FontSize = CurrentTheme.fontSize,
    var fontWeight: FontWeight = CurrentTheme.fontWeight,
    var fontColor: CSSColorValue = CurrentTheme.textColor,
    var fontFamily: String = CurrentTheme.fontFamily,
    var clockFormat: Set<ClockFormat> = setOf(ClockFormat.TWENTY_FOUR_HOUR, ClockFormat.SHOW_ALL),
)
