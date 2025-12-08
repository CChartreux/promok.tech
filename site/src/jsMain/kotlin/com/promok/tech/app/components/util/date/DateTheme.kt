package com.promok.tech.app.components.util.date

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

data class DateTheme(
    override var fontSize: FontSize = currentTheme.fontSize,
    override var fontWeight: FontWeight = currentTheme.fontWeight,
    override var textColor: CSSColorValue = currentTheme.textColor,
    override var fontFamily: String = currentTheme.fontFamily,
    var dateFormat: Set<DateFormat> = setOf(DateFormat.SHOW_ALL),
) : GlobalTheme