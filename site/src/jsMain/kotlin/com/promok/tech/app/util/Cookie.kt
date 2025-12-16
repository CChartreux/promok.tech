package com.promok.tech.app.util

import kotlinx.browser.document
import kotlin.time.Duration

object Cookies {
    enum class SameSite(val value: String) { Strict("Strict"), Lax("Lax"), None("None") }

    fun set(
        name: String,
        value: String,
        maxAge: Duration? = null,  // optional lifetime
        path: String = "/",
        secure: Boolean = true,
        sameSite: SameSite = SameSite.Lax
    ) {
        val parts = mutableListOf("$name=$value", "path=$path", "SameSite=${sameSite.value}")

        if (secure) parts += "Secure"
        if (maxAge != null) parts += "max-age=${maxAge.inWholeSeconds}"

        document.cookie = parts.joinToString("; ")
    }

    /**
     * Returns cookie value if cookie is available
     * @return cookie value - if cookie found else null
     *
     */
    fun getCookie(name: String): String? =
        document.cookie.split("; ")
            .map { it.split("=", limit = 2) }
            .firstOrNull { it[0] == name }
            ?.getOrNull(1)

    fun delete(name: String, path: String = "/") {
        // Set cookie with max-age=0 to remove it
        document.cookie = "$name=; path=$path; max-age=0"
    }
}