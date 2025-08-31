package com.promok.tech.pages

import androidx.compose.runtime.*
import com.promok.tech.components.*
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
            .backgroundImage(url("background_image_homescreen.webp"))
    ) {
        if (unlocked) {
            // Unlocked state content
            Column(
                modifier = Modifier.fillMaxSize().backgroundColor(Color.black)
                    .backgroundImage(url("background_image_homescreen.webp")).color(Color.white).fontFamily("Doto"),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Desktop()
            }
        } else {
            // Locked state with scroll animation
            ScrollUnlockAnimation(onUnlock = { unlocked = true }) { playAnimation ->
                Column(
                    modifier = Modifier
                        .fillMaxSize().backgroundColor(Color.black)
                        .backgroundImage(url("background_image_lockscreen.webp"))
                        .color(Color.white).fontFamily("Doto")
                        .then(
                            if (playAnimation) Modifier.animation(
                                unlockKeyframes.toAnimation(
                                    duration = 0.3.s,
                                    direction = AnimationDirection.Alternate
                                )
                            ) else Modifier
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LockScreenContent()

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        UnlockMessage()
                    }
                }
            }
        }
    }
}