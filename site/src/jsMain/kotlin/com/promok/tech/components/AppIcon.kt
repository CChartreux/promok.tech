package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.functions.CSSFilter
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.filter
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.onMouseDown
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.div
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.Text
import kotlin.js.iterator

@Composable
fun AppIcon(src: String, amount: Int) {
    var hovered by remember { mutableStateOf(false) }
    var opened by remember { mutableStateOf(0) }

    val appIconSize = 58.px

    Column(
        modifier = Modifier
            .padding(right = 10.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(70.px)

                .onMouseEnter { hovered = true }
                .onMouseLeave { hovered = false }

                .onMouseDown { opened++ }


        ) {
            Image(
                src, modifier = Modifier
                    .size(appIconSize)
                    .styleModifier {
                        property("filter", "drop-shadow(4px 4px 10px rgba(0,0,0,0.5))")
                    }
                    .then(
                        if (hovered) Modifier
                            .animation(
                                iconHoverKeyframesUp.toAnimation(
                                    duration = 0.2.s
                                )
                            )

                            .translateY((-10).px)
                        else Modifier
                            .animation(
                                iconHoverKeyframesDown.toAnimation(
                                    duration = 0.2.s
                                )
                            )

                            .translateY(10.px)
                    )
            )

        }

        AppIconCircle(opened)
    }
}

@Composable
fun AppIconCircle(amount: Int) {
    val circleSize = 8.px

    Row {
        for (i in 1..amount) {
            Image(
                "circle.ico",
                modifier = Modifier
                    .size(circleSize)
                //.padding(right = 10.px)
                //.translateX((appIconSize / 2) - (circleSize / 2))
            )
        }
    }
}