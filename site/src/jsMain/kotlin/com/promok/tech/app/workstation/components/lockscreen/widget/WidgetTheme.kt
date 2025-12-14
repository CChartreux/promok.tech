package com.promok.tech.app.workstation.components.lockscreen.widget

import com.promok.tech.themes.GlobalTheme
import com.promok.tech.themes.currentTheme
import com.promok.tech.themes.font.helper.addAlpha
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.*

object WidgetTheme : GlobalTheme {
    var fontSize: FontSize = currentTheme.regularSize
    var fontWeight: FontWeight = currentTheme.lightWeight

    var subtitleFontSize: FontSize = currentTheme.bodySmall
    var subtitleFontWeight: FontWeight = currentTheme.regularWeight

    override var textColor: CSSColorValue = currentTheme.textColor
    override var secondaryTextColor: CSSColorValue = currentTheme.secondaryTextColor.addAlpha(0.9)
    override var fontFamily: String = currentTheme.fontFamily

    fun Modifier.widgetFooter() =
        this
            .width(15.vw)
            .height(12.vh)
            .border(2.px, color = rgb(255, 255, 255))
            .styleModifier {
                property("box-sizing", "border-box")
                property("border-radius", "5px")
                property("background", "rgba(255,255,255,0.05)")
                property("backdrop-filter", "blur(30px)")
            }

    fun Modifier.widgetHeader() =
        this
            .color(textColor)
            .fontSize(fontSize)
            .fontWeight(fontWeight)
            .fontFamily(fontFamily)
}