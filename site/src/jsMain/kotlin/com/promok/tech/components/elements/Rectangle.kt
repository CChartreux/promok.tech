package com.promok.tech.components.elements

import androidx.compose.runtime.Composable
import com.promok.tech.components.theme.AppTheme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px


@Composable
fun Rectangle(
    width: CSSSizeValue<CSSUnit.px>,
    height: CSSSizeValue<CSSUnit.px>,
    borderRadius: CSSSizeValue<CSSUnit.px> = 0.px,
    color: CSSColorValue
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .backgroundColor(color)
            .borderRadius(borderRadius)
    )
}

@Composable
fun Rectangle(
    width: CSSSizeValue<CSSUnit.px>,
    height: CSSSizeValue<CSSUnit.px>,
    borderRadius: CSSSizeValue<CSSUnit.px>,
    color: Triple<Int, Int, Int>
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .backgroundColor(AppTheme.Colors.rgbaFromTriple(color, 1f))
            .borderRadius(borderRadius)
    ) {

    }
}