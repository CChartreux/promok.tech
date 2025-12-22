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
    var fontSize: FontSize = currentTheme.bodySmall
    var fontWeight: FontWeight = currentTheme.mediumWeight

    var subtitleFontSize: FontSize = currentTheme.bodyExtraSmall
    var subtitleFontWeight: FontWeight = currentTheme.regularWeight

    var subtitleFonColor: CSSColorValue = currentTheme.secondaryTextColor.addAlpha(0.5)

    override var textColor: CSSColorValue = currentTheme.textColor
    override var fontFamily: String = currentTheme.fontFamily

    fun Modifier.widget() = this.color(textColor).fontFamily(fontFamily)

        .width(17.vw).height(13.5.vh).border(2.px, color = rgb(255, 255, 255)).styleModifier {
            property("box-sizing", "border-box")
            property("border-radius", "5px")
            property("background", "rgba(255,255,255,0.05)")
            property("backdrop-filter", "blur(30px)")
        }
}