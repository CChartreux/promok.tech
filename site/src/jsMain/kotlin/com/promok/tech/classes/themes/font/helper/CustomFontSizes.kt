package com.promok.tech.classes.themes.font.helper

import com.varabyte.kobweb.compose.css.FontSize

val FontSize.Companion.Huge: FontSize
    get() = "6rem".unsafeCast<FontSize>()

val FontSize.Companion.Massive: FontSize
    get() = "8rem".unsafeCast<FontSize>()
