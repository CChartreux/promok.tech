package com.promok.tech.old.pages

import androidx.compose.runtime.*
import com.promok.tech.old.components.animations.ScrollUnlockAnimation
import com.promok.tech.old.components.animations.unlockKeyframes
import com.promok.tech.old.components.desktop.Desktop
import com.promok.tech.old.components.lockscreen.LockScreenContent
import com.promok.tech.old.components.lockscreen.UnlockMessage
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationDirection
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.s

@Page
@Composable
fun HomePage() {
    var unlocked by remember { mutableStateOf(false) }

    // Parent container with static background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Color.black)
            .backgroundImage(url("background/background_image_homescreen.webp"))
            .overflow(Overflow.Hidden)
    ) {
        if (unlocked) {
            // Unlocked state content
            Column(
                modifier = Modifier.fillMaxSize().backgroundColor(Color.black)
                    .backgroundImage(url("background/background_image_homescreen.webp")).color(Color.white)
                    .fontFamily("Doto"),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                _root_ide_package_.com.promok.tech.old.components.desktop.Desktop()
            }
        } else {
            // Locked state with scroll animation
            _root_ide_package_.com.promok.tech.old.components.animations.ScrollUnlockAnimation(onUnlock = {
                unlocked = true
            }) { playAnimation ->
                Column(
                    modifier = Modifier
                        .fillMaxSize().backgroundColor(Color.black)
                        .backgroundImage(url("background/background_image_lockscreen.webp"))
                        .color(Color.white).fontFamily("Doto")
                        .then(
                            if (playAnimation) Modifier.animation(
                                _root_ide_package_.com.promok.tech.old.components.animations.unlockKeyframes.toAnimation(
                                    duration = 0.3.s,
                                    direction = AnimationDirection.Alternate
                                )
                            ) else Modifier
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    _root_ide_package_.com.promok.tech.old.components.lockscreen.LockScreenContent()

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        _root_ide_package_.com.promok.tech.old.components.lockscreen.UnlockMessage()
                    }
                }
            }
        }
    }
}