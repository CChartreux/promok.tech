package com.promok.tech.app.components.util.lockscreen.widgets

import androidx.compose.runtime.Composable

interface Widget {
    @Composable
    fun render()

    val title: String
    val seeMoreText: String
}