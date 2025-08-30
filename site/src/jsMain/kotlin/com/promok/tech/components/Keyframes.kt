package com.promok.tech.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.unaryMinus

val upAndDownKeyframes = Keyframes {
    from { Modifier.translateY(10.px) }
    to { Modifier.translateY((-10).px) }
}

val unlockKeyframes = Keyframes {
    from { Modifier.translateY(0.percent) }
    to { Modifier.translateY((-100).percent) }
}

val iconHoverKeyframesUp = Keyframes {
    from { Modifier.translateY(0.px) }
    to { Modifier.translateY(-(10).px) }
}

val iconHoverKeyframesDown = Keyframes {
    from { Modifier.translateY(0.px) }
    to { Modifier.translateY(10.px) }
}