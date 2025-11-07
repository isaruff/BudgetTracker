package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) DarkNeoBrutal else LightNeoBrutal
    CompositionLocalProvider(
        LocalColorSchemeV2 provides colorScheme,
        LocalTypography provides AppTypography,
        LocalDimens provides DefaultAppDimensions,
        LocalAppShapes provides DefaultAppShapes
    ) {
        content()
    }
}

object AppTheme {
    val typography
        @Composable
        get() = LocalTypography.current

    val color
        @Composable
        get() = LocalColorSchemeV2.current

    val dimens
        @Composable
        get() = LocalDimens.current

    val shapes
        @Composable
        get() = LocalAppShapes.current
}