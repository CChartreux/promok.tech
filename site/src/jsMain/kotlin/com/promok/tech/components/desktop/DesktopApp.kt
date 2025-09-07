package com.promok.tech.components.desktop

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.components.theme.AppTheme
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

data class DesktopApp(
    val name: String,
    val icon: String,
    val baseColor: MutableState<Triple<Int, Int, Int>> = mutableStateOf(Triple(0, 255, 255)),
    val isOpened: MutableState<Boolean> = mutableStateOf(false),
    val isMaximized: MutableState<Boolean> = mutableStateOf(false),
    val isMinimized: MutableState<Boolean> = mutableStateOf(false),
    val isClicked: MutableState<Boolean> = mutableStateOf(true),
    val zIndex: MutableState<Int> = mutableStateOf(0),
    val height: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(AppTheme.Sizes.defaultWindowHeight),
    val width: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(AppTheme.Sizes.defaultWindowWidth),
    val positionX: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    val positionY: MutableState<CSSSizeValue<CSSUnit.px>> = mutableStateOf(0.px),
    val isPeeking: MutableState<Boolean> = mutableStateOf(false),
    val oldZIndex: MutableState<Int> = mutableStateOf(0),
    val isResizeable: MutableState<Boolean> = mutableStateOf(true),
)