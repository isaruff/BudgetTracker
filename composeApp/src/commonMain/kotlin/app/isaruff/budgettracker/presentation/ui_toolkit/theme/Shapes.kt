package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppShapes = staticCompositionLocalOf<AppShapes> { error("Shapes not provided") }

data class AppShapes(
    val flat: RoundedCornerShape,
    val small: RoundedCornerShape,
    val medium: RoundedCornerShape,
    val large: RoundedCornerShape
)

val DefaultAppShapes: AppShapes
    @Composable
    get() {
        val dimens = AppTheme.dimens
        return AppShapes(
            flat = RoundedCornerShape(dimens.cornerNone),
            small = RoundedCornerShape(dimens.cornerSm),
            medium = RoundedCornerShape(dimens.cornerMd),
            large = RoundedCornerShape(dimens.cornerLg)
        )
    }
