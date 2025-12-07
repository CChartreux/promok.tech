package com.promok.tech.classes.themes

import androidx.compose.runtime.Immutable
import com.promok.tech.classes.ClockFormat
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumericValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Immutable
data class ClockTheme(
    val fontSize: CSSNumericValue<out CSSUnit> = 16.px,
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontColor: CSSColorValue = rgb(255, 255, 255),
    val clockFormat: Set<ClockFormat> = setOf(ClockFormat.TWENTY_FOUR_HOUR, ClockFormat.SHOW_ALL),
)
