package com.promok.tech.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun AppIcon(src: String) {
    var hovered by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(70.px)
            .padding(right = 10.px)

            .onMouseEnter { hovered = true }
            .onMouseLeave { hovered = false }


    ) {
        Image(
            src, modifier = Modifier
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
}