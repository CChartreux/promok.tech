// utils/DragHandler.kt
package com.promok.tech.utils

import androidx.compose.runtime.MutableState
import org.jetbrains.compose.web.css.*
import org.w3c.dom.events.MouseEvent

class DragHandler(
    private val offsetX: MutableState<CSSSizeValue<CSSUnit.px>>,
    private val offsetY: MutableState<CSSSizeValue<CSSUnit.px>>,
    private val onDragStart: (() -> Unit)? = null,
    private val onDragEnd: (() -> Unit)? = null
) {
    private var initialClickX = 0.px
    private var initialClickY = 0.px
    private var dragStartX = 0.px
    private var dragStartY = 0.px
    private var isDragging = false

    fun onMouseDown(event: MouseEvent) {
        isDragging = true
        initialClickX = event.clientX.px
        initialClickY = event.clientY.px
        dragStartX = offsetX.value
        dragStartY = offsetY.value
        onDragStart?.invoke()
    }

    fun onMouseMove(event: MouseEvent) {
        if (isDragging) {
            offsetX.value = dragStartX + (event.clientX.px - initialClickX)
            offsetY.value = dragStartY + (event.clientY.px - initialClickY)
        }
    }

    fun onMouseUp() {
        isDragging = false
        onDragEnd?.invoke()
    }

    fun isDragging(): Boolean = isDragging
}