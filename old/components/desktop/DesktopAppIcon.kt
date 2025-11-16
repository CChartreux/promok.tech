package com.promok.tech.old.components.desktop

import androidx.compose.runtime.*
import com.promok.tech.old.components.animations.iconHoverKeyframesDown
import com.promok.tech.old.components.animations.iconHoverKeyframesUp
import com.promok.tech.old.components.theme.AppTheme
import com.promok.tech.old.services.DesktopService
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
fun DesktopAppIcon(desktopApp: com.promok.tech.old.components.desktop.DesktopApp) {
    var isHovered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(right = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.taskbarPaddingHorizontal / 3),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = _root_ide_package_.com.varabyte.kobweb.compose.ui.Modifier.Companion
                .height(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.desktopIconContainerHeight)
                .onMouseEnter {
                    isHovered = true
                    desktopApp.isPeeking.value = true
                }
                .onMouseLeave {
                    isHovered = false
                    desktopApp.isPeeking.value = false
                }
                .onMouseDown {
                    _root_ide_package_.com.promok.tech.old.services.DesktopService.openApp(desktopApp)
                }
        ) {
            Image(
                desktopApp.icon,
                modifier = Modifier
                    .size(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.appIconSize)
                    .styleModifier {
                        property(
                            "opacity",
                            if (desktopApp.isOpened.value)
                                _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Opacity.appIconActive
                            else
                                _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Opacity.appIconInactive
                        )
                    }
                    .then(
                        if (isHovered) Modifier
                            .animation(
                                _root_ide_package_.com.promok.tech.old.components.animations.iconHoverKeyframesUp.toAnimation(
                                    duration = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Animations.iconHoverDuration
                                )
                            )
                            .translateY(-_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.desktopIconHoverTranslation)
                        else Modifier
                            .animation(
                                _root_ide_package_.com.promok.tech.old.components.animations.iconHoverKeyframesDown.toAnimation(
                                    duration = _root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Animations.iconHoverDuration
                                )
                            )
                            .translateY(_root_ide_package_.com.promok.tech.old.components.theme.AppTheme.Sizes.desktopIconHoverTranslation)
                    )
            )
        }
    }
}