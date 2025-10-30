package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorScheme = staticCompositionLocalOf { LightNeobrutalColorScheme }

val OrangeAccent = Color(0xFFFF9F1C)
val VividRed = Color(0xFFE71D36)
val TealPop = Color(0xFF2EC4B6)
val OffWhite = Color(0xFFFDFFFC)
val DeepNavy = Color(0xFF011627)
val PureWhite = Color(0xFFFFFFFF)
val NavySurface = Color(0xFF0B1B2B)
val DarkGrayText = Color(0xFF3D3D3D)
val LightGrayText = Color(0xFFB8C2CC)

data class AppColorScheme(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val accent: Color,
    val onAccent: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val border: Color,
    val error: Color
)

val LightNeobrutalColorScheme = AppColorScheme(
    background = OffWhite,
    onBackground = DeepNavy,
    surface = PureWhite,
    primary = OrangeAccent,
    onPrimary = DeepNavy,
    secondary = TealPop,
    onSecondary = DeepNavy,
    accent = VividRed,
    onAccent = OffWhite,
    textPrimary = DeepNavy,
    textSecondary = DarkGrayText,
    border = DeepNavy,
    error = VividRed
)

val DarkNeobrutalColorScheme = AppColorScheme(
    background = DeepNavy,
    onBackground = OffWhite,
    surface = NavySurface,
    primary = TealPop,
    onPrimary = OffWhite,
    secondary = OrangeAccent,
    onSecondary = DeepNavy,
    accent = VividRed,
    onAccent = OffWhite,
    textPrimary = OffWhite,
    textSecondary = LightGrayText,
    border = TealPop,
    error = VividRed
)


