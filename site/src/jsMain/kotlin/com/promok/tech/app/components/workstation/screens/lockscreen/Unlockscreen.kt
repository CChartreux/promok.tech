package com.promok.tech.app.components.workstation.screens.lockscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    private val _isWorkstationUnlocking = mutableStateOf(false)
    val isWorkstationUnlocking get() = mutableStateOf(false)

    fun unlockWorkstation() {
        _isWorkstationUnlocking.value = true
    }

    fun lockWorkstation() {
        _isWorkstationUnlocking.value = false;
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