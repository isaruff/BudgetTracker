package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) DarkNeobrutalColorScheme else LightNeobrutalColorScheme

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
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
        get() = LocalColorScheme.current

    val dimens
        @Composable
        get() = LocalDimens.current

    val shapes
        @Composable
        get() = LocalAppShapes.current
}