package com.promok.tech.app.workstation.components.reusable.clock

enum class ClockFormat(val displayName: String) {
    TWELVE_HOUR("12h"),
    TWENTY_FOUR_HOUR("24h"),

    SHOW_SECONDS("Show seconds"),
    SHOW_MINUTES("Show minutes"),
    SHOW_HOURS("Show hours"),
    SHOW_ALL("Show all");
}