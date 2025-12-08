package com.promok.tech.app.components.workstation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.promok.tech.app.components.workstation.screens.dekstop.Desktop
import com.promok.tech.app.components.workstation.screens.lockscreen.Lockscreen

class Workstation() {
    private val isWorkstationUnlocked: MutableState<Boolean> = mutableStateOf(false)

    private val desktop: Desktop = Desktop(isWorkstationUnlocked)
    private val lockscreen: Lockscreen = Lockscreen(isWorkstationUnlocked)

    @Composable
    fun render() {
        if (isWorkstationUnlocked.value) desktop.render()
        else lockscreen.render()
    }
}