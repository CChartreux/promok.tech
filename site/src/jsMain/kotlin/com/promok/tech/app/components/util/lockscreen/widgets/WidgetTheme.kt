package com.promok.tech.app.components.util.lockscreen.widgets

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import com.promok.tech.themes.font.helper.addAlpha
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import org.jetbrains.compose.web.css.CSSColorValue

object WidgetTheme : GlobalTheme {
    override var fontSize: FontSize = currentTheme.fontSize
    override var fontWeight: FontWeight = currentTheme.fontWeight
    override var textColor: CSSColorValue = currentTheme.textColor
    override var secondaryTextColor: CSSColorValue = currentTheme.secondaryTextColor.addAlpha(0.9)
    override var fontFamily: String = currentTheme.fontFamily
}