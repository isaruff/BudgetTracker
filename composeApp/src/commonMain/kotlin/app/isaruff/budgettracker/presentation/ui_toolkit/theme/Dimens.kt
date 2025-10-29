package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDimens = staticCompositionLocalOf { DefaultAppDimensions }

data class AppDimensions(
    val spacingXs: Dp,
    val spacingSm: Dp,
    val spacingMs: Dp,
    val spacingMd: Dp,
    val spacingLg: Dp,
    val spacingXl: Dp,
    val cornerNone: Dp,
    val cornerSm: Dp,
    val cornerMd: Dp,
    val cornerLg: Dp,
    val borderThin: Dp,
    val borderMedium: Dp,
    val borderThick: Dp,
    val iconSizeSm: Dp,
    val iconSizeMd: Dp,
    val iconSizeLg: Dp,
    val elevationFlat: Dp,
    val elevationSlight: Dp
)

val DefaultAppDimensions = AppDimensions(
    spacingXs = 4.dp,
    spacingSm = 8.dp,
    spacingMs = 12.dp,
    spacingMd = 16.dp,
    spacingLg = 24.dp,
    spacingXl = 32.dp,
    cornerNone = 0.dp,
    cornerSm = 4.dp,
    cornerMd = 8.dp,
    cornerLg = 16.dp,
    borderThin = 2.dp,
    borderMedium = 3.dp,
    borderThick = 4.dp,
    iconSizeSm = 16.dp,
    iconSizeMd = 24.dp,
    iconSizeLg = 32.dp,
    elevationFlat = 0.dp,
    elevationSlight = 2.dp
)

