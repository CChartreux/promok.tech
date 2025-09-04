package com.promok.tech.components.window

import androidx.compose.runtime.*
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.theme.AppTheme
import com.promok.tech.services.DesktopService
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

@Composable
fun TitleBar(
    desktopApp: DesktopApp,
    offsetX: MutableState<CSSSizeValue<CSSUnit.px>>,
    offsetY: MutableState<CSSSizeValue<CSSUnit.px>>
) {
    var initialClickX by remember { mutableStateOf(AppTheme.Defaults.position) }
    var initialClickY by remember { mutableStateOf(AppTheme.Defaults.position) }
    var dragStartX by remember { mutableStateOf(AppTheme.Defaults.position) }
    var dragStartY by remember { mutableStateOf(AppTheme.Defaults.position) }
    var isDragging by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .thenIf(desktopApp.isPeeking.value) {
                Modifier.boxShadow(blurRadius = AppTheme.Sizes.windowShadowBlur, color = AppTheme.Colors.windowGray)
            }
    ) {
        Box(
            modifier = Modifier
                .position(Position.Absolute)
                .onMouseDown { event ->
                    isDragging = true
                    initialClickX = event.clientX.px
                    initialClickY = event.clientY.px
                    dragStartX = offsetX.value
                    dragStartY = offsetY.value
                }
                .onDoubleClick { desktopApp.isMaximized.value = !desktopApp.isMaximized.value }
                .then(
                    if (isDragging) {
                        Modifier
                            .onMouseMove { event ->
                                if (desktopApp.isMaximized.value) {
                                    DesktopService.maximizeApp(desktopApp)
                                }

                                offsetX.value = dragStartX + (event.clientX.px - initialClickX)
                                offsetY.value = dragStartY + (event.clientY.px - initialClickY)
                                desktopApp.positionX.value = offsetX.value
                                desktopApp.positionY.value = offsetY.value
                            }
                            .width(AppTheme.Sizes.dragBoxWidth)
                            .height(AppTheme.Sizes.dragBoxHeight)
                            .translate(AppTheme.Sizes.dragBoxTranslation, AppTheme.Sizes.dragBoxTranslation)
                            .onMouseUp { isDragging = false }
                    } else {
                        Modifier
                            .width(desktopApp.width.value)
                            .height(AppTheme.Sizes.titleBarHeight)
                    }
                )
        )

        Row(
            modifier = Modifier
                .width(desktopApp.width.value)
                .height(AppTheme.Sizes.titleBarHeight)
                .backgroundColor(AppTheme.Colors.windowGray)
                .color(AppTheme.Colors.black)
                .fontWeight(FontWeight.ExtraBlack)
                .borderRadius(
                    topRight = AppTheme.Borders.windowRadiusTop,
                    topLeft = AppTheme.Borders.windowRadiusTop
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WindowControl(desktopApp, AppTheme.Sizes.windowControlIconSize)

            Box(
                modifier = Modifier
                    .translateX((desktopApp.width.value / 2) - (AppTheme.Sizes.windowControlIconSize * 3 + 16.px))
            ) {
                Text(desktopApp.name)
            }
        }
    }
}