package com.promok.tech.app.workstation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Workstation() {
    private val isWorkstationUnlocked: MutableState<Boolean> = mutableStateOf(false)

    private val desktop: com.promok.tech.app.workstation.screens.dekstop.Desktop =
        _root_ide_package_.com.promok.tech.app.workstation.screens.dekstop.Desktop(isWorkstationUnlocked)
    private val lockscreen: com.promok.tech.app.workstation.screens.lockscreen.Lockscreen =
        _root_ide_package_.com.promok.tech.app.workstation.screens.lockscreen.Lockscreen(isWorkstationUnlocked)

    @Composable
    fun render() {
        if (isWorkstationUnlocked.value) desktop.render()
        else lockscreen.render()
    }
}