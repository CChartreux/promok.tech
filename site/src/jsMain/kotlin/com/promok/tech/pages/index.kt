package com.promok.tech.pages

import androidx.compose.runtime.Composable
import com.promok.tech.app.workstation.Workstation
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun index() {
    val workstation = Workstation()
    workstation.render()
}