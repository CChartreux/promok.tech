package com.promok.tech.app.workstation.components.lockscreen.widgets

import androidx.compose.runtime.Composable

interface Widget {
    @Composable
    fun render()

    val title: String
    val seeMoreText: String
}