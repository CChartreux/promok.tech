package com.promok.tech.components.desktop

import androidx.compose.runtime.*
import com.promok.tech.components.animations.iconHoverKeyframesDown
import com.promok.tech.components.animations.iconHoverKeyframesUp
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.services.DesktopService
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.div
import org.jetbrains.compose.web.css.unaryMinus

@Composable
fun DesktopAppIcon(desktopApp: DesktopApp) {
    var isHovered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(right = AppTheme.Sizes.taskbarPaddingHorizontal / 3),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(AppTheme.Sizes.desktopIconContainerHeight)
                .onMouseEnter {
                    isHovered = true
                    desktopApp.isPeeking.value = true
                }
                .onMouseLeave {
                    isHovered = false
                    desktopApp.isPeeking.value = false
                }
                .onMouseDown {
                    DesktopService.openApp(desktopApp)
                }
        ) {
            Image(
                desktopApp.icon,
                modifier = Modifier
                    .size(AppTheme.Sizes.appIconSize)
                    .styleModifier {
                        property(
                            "opacity",
                            if (desktopApp.isOpened.value)
                                AppTheme.Opacity.appIconActive
                            else
                                AppTheme.Opacity.appIconInactive
                        )
                    }
                    .then(
                        if (isHovered) Modifier
                            .animation(
                                iconHoverKeyframesUp.toAnimation(
                                    duration = AppTheme.Animations.iconHoverDuration
                                )
                            )
                            .translateY(-AppTheme.Sizes.desktopIconHoverTranslation)
                        else Modifier
                            .animation(
                                iconHoverKeyframesDown.toAnimation(
                                    duration = AppTheme.Animations.iconHoverDuration
                                )
                            )
                            .translateY(AppTheme.Sizes.desktopIconHoverTranslation)
                    )
            )
        }
    }
}