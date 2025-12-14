import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link


plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)

    kotlin("plugin.serialization") version "1.9.0"
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.promok.tech"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")
            }

            description.set("Portfolio Website from Peter Promok; Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("tech")

    sourceSets {
        jsMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            //implementation(project(":worker"))
        }
    }
}
