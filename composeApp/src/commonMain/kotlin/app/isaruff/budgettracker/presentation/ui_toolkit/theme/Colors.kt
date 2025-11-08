package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorScheme = staticCompositionLocalOf { NeoBrutalLight }


// Base structural tones
val BrutalCream = Color(0xFFFFFBEA)
val BrutalWhite = Color(0xFFFFFFFF)
val BrutalBlack = Color(0xFF000000)
val BrutalCharcoal = Color(0xFF1C1D21)
val BrutalIron = Color(0xFF2B2C31)

// Vibrant action tones
val BrutalBlue = Color(0xFF118AB2)
val BrutalCyan = Color(0xFF4CC9F0)
val BrutalYellow = Color(0xFFFFD166)
val BrutalGold = Color(0xFFEFBF57)
val BrutalViolet = Color(0xFFB388EB)
val BrutalLavender = Color(0xFFC29FFF)

// Functional tones
val BrutalGreen = Color(0xFF06D6A0)
val BrutalMint = Color(0xFF4ADE80)
val BrutalAmber = Color(0xFFF3C623)
val BrutalSun = Color(0xFFF7D154)
val BrutalRed = Color(0xFFEF476F)
val BrutalPink = Color(0xFFFF6584)

val BrutalGrey = Color(0xFF333333)
val BrutalPaleWhite = Color(0xFFE8E8E8)


data class NeoBrutalColorScheme(
    val background: Color,
    val surface: Color,
    val outline: Color,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val success: Color,
    val warning: Color,
    val error: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onTertiary: Color
)

val NeoBrutalLight = NeoBrutalColorScheme(
    background = BrutalCream,
    surface = BrutalWhite,
    outline = BrutalBlack,
    primary = BrutalBlue,
    secondary = BrutalYellow,
    tertiary = BrutalViolet,
    success = BrutalGreen,
    warning = BrutalAmber,
    error = BrutalRed,
    textPrimary = BrutalBlack,
    textSecondary = BrutalGrey,
    onBackground = BrutalBlack,
    onSurface = BrutalBlack,
    onPrimary = BrutalWhite,
    onSecondary = BrutalBlack,
    onTertiary = BrutalWhite
)

val NeoBrutalDark = NeoBrutalColorScheme(
    background = BrutalCharcoal,
    surface = BrutalIron,
    outline = BrutalWhite,
    primary = BrutalCyan,
    secondary = BrutalGold,
    tertiary = BrutalLavender,
    success = BrutalMint,
    warning = BrutalSun,
    error = BrutalPink,
    textPrimary = BrutalWhite,
    textSecondary = BrutalPaleWhite,
    onBackground = BrutalWhite,
    onSurface = BrutalWhite,
    onPrimary = BrutalBlack,
    onSecondary = BrutalBlack,
    onTertiary = BrutalBlack
)
