package com.promok.tech.components.pages

import androidx.compose.runtime.Composable
import com.promok.tech.components.desktop.DesktopApp
import com.promok.tech.components.elements.Rectangle
import com.promok.tech.components.theme.AppTheme
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProfilePage(desktopApp: DesktopApp) {
    desktopApp.isResizeable.value = false
    desktopApp.width.value = 600.px
    desktopApp.height.value = 0.px

    Column(
        modifier = Modifier
            .backgroundColor(AppTheme.Colors.currentTheme.backgroundPrimary)
            .padding(16.px)
            .borderRadius(bottomLeft = 30.px, bottomRight = 30.px)
            .overflow(Overflow.Hidden) // Clip content to rounded corners
    ) {
        ProfileHeader()

        Column {
            cVSection("2007", "Born in Salzburg")
            cVSection("2018 - 2022", "Gymnasium St. Ursula - Sprache")
            cVSection("SINCE 2022", "HTL Salzburg - Elektronik & Technische Informatik")
        }
    }
}

@Composable
fun cVSection(date: String, content: String) {
    Row {
        Box() {
            Box(
                modifier = Modifier
                    .padding(top = 15.px)
            ) {
                Rectangle(16.px, 16.px, 3.px, AppTheme.Colors.currentTheme.accentColor)
            }
            Box(
                modifier = Modifier
                    .padding(left = 7.px)
            ) {
                Rectangle(2.px, 80.px, 0.px, AppTheme.Colors.currentTheme.accentColor)
            }
        }

        Column(
            modifier = Modifier
                .padding(left = 15.px, top = 5.px)
        ) {
            Box(
                modifier = Modifier
                    .fontSize(FontSize.Medium)
                    .fontWeight(FontWeight.SemiBold)
                    .padding(bottom = 15.px)
                    .color(
                        AppTheme.Colors.rgbaFromTriple(
                            AppTheme.Colors.currentTheme.accentColor, 1f
                        )
                    )
            ) { Text(date) }

            Box(
                modifier = Modifier
                    .fontWeight(FontWeight.ExtraBlack)
                    .fontSize(FontSize.Large)
                    .color(AppTheme.Colors.currentTheme.textPrimary)
            ) { Text(content) }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            Box(
                modifier = Modifier
                    .fontSize(FontSize.XXLarge)
                    .fontWeight(FontWeight.Bold)
                    .color(AppTheme.Colors.currentTheme.textPrimary)
            ) {
                Text(
                    "Peter Promok"
                )
            }

            Box(
                modifier = Modifier
                    .fontSize(FontSize.Large)
                    .color(AppTheme.Colors.currentTheme.textSecondary)
            ) {

                Text(
                    "Software Developer & Student"
                )
            }

            Box(
                modifier = Modifier
                    .padding(top = 10.px, bottom = 20.px)

            ) {
                Rectangle(600.px, 1.px, 0.px, AppTheme.Colors.currentTheme.textPrimary)
            }
        }
    }

}