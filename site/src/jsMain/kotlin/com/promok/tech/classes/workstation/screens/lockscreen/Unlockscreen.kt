package com.promok.tech.classes.workstation.screens.lockscreen

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Text

class Unlockscreen(private val isWorkstationUnlocked: MutableState<Boolean>) {
    private val _isWorkstationUnlocking: MutableState<Boolean> = mutableStateOf(false)
    val isWorkstationUnlocking: State<Boolean> get() = _isWorkstationUnlocking
    fun unlockWorkstation() {
        _isWorkstationUnlocking.value = true
    }

    fun lockWorkstation() {
        _isWorkstationUnlocking.value = false
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
        val password: MutableState<String> = mutableStateOf("")

        Box(
            modifier = Modifier
                .fillMaxSize()
                .display(DisplayStyle.Flex)
                .justifyContent(JustifyContent.Center) // horizontal alignment
                .alignItems(AlignItems.Center)         // vertical alignment
        ) {
            Input(InputType.Password) {
                onInput { inputEvent -> password.value = inputEvent.value }
            }
        }
    }

    @Composable
    private fun pinField() {
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