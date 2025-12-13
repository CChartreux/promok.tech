package com.promok.tech.app.workstation.components.lockscreen.widgets

import androidx.compose.runtime.Composable
import com.promok.tech.app.workstation.components.Components

abstract class WidgetComponent : Components {
    abstract val widget: Widget

    @Composable
    abstract fun widgetContent()

    @Composable
    final override fun render() {
        widget.render {
            widgetContent()
        }
    }
}