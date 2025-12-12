package com.promok.tech.app.workstation.components.lockscreen.date

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import org.jetbrains.compose.web.css.CSSColorValue

data class DateTheme(
    override var textColor: CSSColorValue = currentTheme.textColor,
    override var fontFamily: String = currentTheme.fontFamily,
    var dateFormat: Set<DateFormat> = setOf(DateFormat.SHOW_ALL),
) : GlobalTheme