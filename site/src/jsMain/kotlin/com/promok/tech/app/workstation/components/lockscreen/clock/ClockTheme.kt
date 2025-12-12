package com.promok.tech.app.workstation.components.lockscreen.clock

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import org.jetbrains.compose.web.css.CSSColorValue

data class ClockTheme(
    override var textColor: CSSColorValue = currentTheme.textColor,
    override var fontFamily: String = currentTheme.fontFamily,
    var clockFormat: Set<ClockFormat> = setOf(ClockFormat.SHOW_ALL, ClockFormat.TWENTY_FOUR_HOUR),
) : GlobalTheme