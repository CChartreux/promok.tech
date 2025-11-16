package com.promok.tech.old.components.lockscreen

import androidx.compose.runtime.Composable
import com.promok.tech.old.components.animations.upAndDownKeyframes
import com.promok.tech.old.components.theme.AppTheme
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationDirection
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun UnlockMessage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fontSize(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.unlockMessageFontSize)
            .padding(bottom = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.unlockMessagePaddingBottom),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FaArrowUp(
            modifier = Modifier
                .padding(bottom = 15.px)
                .color(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Specific.lockscreenTextSecondary)
                .animation(
                    _root_ide_package_.com.promok.tech.old.components.animations.upAndDownKeyframes.toAnimation(
                        duration = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Animations.unlockAnimationDuration,
                        iterationCount = AnimationIterationCount.Infinite,
                        timingFunction = AnimationTimingFunction.EaseInOut,
                        direction = AnimationDirection.Alternate
                    )
                )
        )

        Box(modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion.color(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Colors.Specific.lockscreenTextSecondary)) {
            Text("SCROLL UP TO UNLOCK")
        }
    }
}