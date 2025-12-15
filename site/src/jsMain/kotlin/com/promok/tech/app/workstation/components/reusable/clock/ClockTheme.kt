package com.promok.tech.app.workstation.components.reusable.clock

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

data class ClockTheme(
    var fontSize: FontSize = currentTheme.regularSize,
    var fontWeight: FontWeight = currentTheme.regularWeight,
    override var textColor: CSSColorValue = currentTheme.textColor,
    override var fontFamily: String = currentTheme.fontFamily,

    var clockFormat: Set<ClockFormat> = setOf(ClockFormat.SHOW_ALL, ClockFormat.TWENTY_FOUR_HOUR),
) : GlobalTheme