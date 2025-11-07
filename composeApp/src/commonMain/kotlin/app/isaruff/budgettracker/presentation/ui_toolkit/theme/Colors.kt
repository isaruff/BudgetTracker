package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorSchemeV2 = staticCompositionLocalOf { LightNeoBrutal }


val ChalkWhite = Color(0xFFFFFCF5)
val GraphiteBlack = Color(0xFF1C1C1C)
val IronGray = Color(0xFF2A2A2A)
val InkBlack = Color(0xFF1A1A1A)
val PaperWhite = Color(0xFFFFFFFF)
val BoneWhite = Color(0xFFF5F5F5)
val ChalkOutline = Color(0xFFFFFFFF)
val OrangeAccent = Color(0xFFFF9F1C)
val TealPop = Color(0xFF2EC4B6)
val MintSuccess = Color(0xFF70C1B3)
val LemonWarning = Color(0xFFF3C623)
val VividRed = Color(0xFFE71D36)
val InkText = Color(0xFF0D0D0D)
val CharcoalText = Color(0xFF121212)
val SnowText = Color(0xFFFFFFFF)
val OffWhiteText = Color(0xFFF5F5F5)
val SolidBlackText = Color(0xFF000000)

data class NeoBrutalColorScheme(
    val background: Color,
    val surface: Color,
    val outline: Color,
    val primary: Color,
    val secondary: Color,
    val success: Color,
    val warning: Color,
    val error: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onPrimary: Color,
    val onSecondary: Color
)

val LightNeoBrutal = NeoBrutalColorScheme(
    background = ChalkWhite,
    surface = PaperWhite,
    outline = InkBlack,
    primary = TealPop,
    secondary = OrangeAccent,
    success = MintSuccess,
    warning = LemonWarning,
    error = VividRed,
    onBackground = InkText,
    onSurface = CharcoalText,
    onPrimary = SolidBlackText,
    onSecondary = SolidBlackText
)

val DarkNeoBrutal = NeoBrutalColorScheme(
    background = GraphiteBlack,
    surface = IronGray,
    outline = ChalkOutline,
    primary = TealPop,
    secondary = OrangeAccent,
    success = MintSuccess,
    warning = LemonWarning,
    error = VividRed,
    onBackground = SnowText,
    onSurface = OffWhiteText,
    onPrimary = SolidBlackText,
    onSecondary = SolidBlackText
)