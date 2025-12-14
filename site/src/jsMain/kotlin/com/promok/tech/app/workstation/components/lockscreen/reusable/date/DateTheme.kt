package com.promok.tech.app.workstation.components.lockscreen.reusable.date

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

data class DateTheme(
    var fontSize: FontSize = currentTheme.regularSize,
    var fontWeight: FontWeight = currentTheme.regularWeight,
    override var textColor: CSSColorValue = currentTheme.textColor,
    override var fontFamily: String = currentTheme.fontFamily,
    var dateFormat: Set<DateFormat> = mutableSetOf(DateFormat.SHOW_ALL),
) : GlobalTheme