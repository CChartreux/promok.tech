package com.promok.tech.app.components.workstation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.varabyte.kobweb.compose.css.functions.CSSUrl

interface Screen {
    val backgroundImageUrl: State<CSSUrl>

    @Composable
    fun render()
}