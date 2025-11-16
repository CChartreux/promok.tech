package com.promok.tech.components.screens.lockscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.AlignContent
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

class Unlockscreen(private val isWorkstationUnlocked: MutableState<Boolean>) {
    private val _isWorkstationUnlocking: MutableState<Boolean> = mutableStateOf(false)
    val isWorkstationUnlocking: State<Boolean> get() = _isWorkstationUnlocking
    fun setWorkstationToUnlocking() {
        _isWorkstationUnlocking.value = true
    }

    fun setWorkstationToLocked() {
        _isWorkstationUnlocking.value = true
    }

    @Composable
    fun render() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .overflow(Overflow.Hidden)
                .styleModifier {
                    property("backdrop-filter", "blur(8px)")
                }
        ) {
            passwordField()
        }
    }

    @Composable
    private fun passwordField() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .display(DisplayStyle.Flex)
                .justifyContent(JustifyContent.Center) // horizontal alignment
                .alignItems(AlignItems.Center)         // vertical alignment
        ) {
            val buttonNumberCounter = remember { mutableStateOf(1) }

            Column {
                (1..3).forEach { _ ->
                    Row {
                        (1..3).forEach { _ ->
                            Button {
                                Text("${buttonNumberCounter.value}")
                            }

                            buttonNumberCounter.value++
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun userSelectField() {

    }
}