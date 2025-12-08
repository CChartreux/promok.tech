package com.promok.tech.themes.font.helper

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba

fun CSSColorValue.addAlpha(alpha: Double): CSSColorValue {
    var lAlpha = 1.0
    if (alpha in 0.0..1.0) lAlpha = alpha

    var base = this.toString()
    base = base.substringAfter('(')

    val parts = base.split(',')

    val r = parts[0].trim().toInt()
    val g = parts[1].trim().toInt()
    val b = parts[2].removeSuffix(")").trim().toInt()

    return rgba(r, g, b, lAlpha)
}