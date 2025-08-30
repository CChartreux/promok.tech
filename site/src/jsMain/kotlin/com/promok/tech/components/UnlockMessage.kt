package com.promok.tech.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationDirection
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Text
import com.promok.tech.components.upAndDownKeyframes


@Composable
fun UnlockMessage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fontSize(200.percent)
            .padding(bottom = 30.px),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        FaArrowUp(
            modifier = Modifier
                .padding(bottom = 15.px)
                .animation(
                    upAndDownKeyframes.toAnimation(
                        duration = 1.s,
                        iterationCount = AnimationIterationCount.Infinite,
                        timingFunction = AnimationTimingFunction.EaseInOut,
                        direction = AnimationDirection.Alternate
                    )
                )
        )

        Text(
            "SCROLL UP TO UNLOCK"
        )
    }

}