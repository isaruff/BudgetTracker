package app.isaruff.budgettracker.presentation.ui_toolkit.components.progressbar

import androidx.compose.runtime.Composable
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme

object NBLinearProgressBarDefaults {

    val Height
        @Composable
        get() = AppTheme.dimens.spacingMd

    val Shape
        @Composable
        get() = AppTheme.shapes.medium

    val TrackColor
        @Composable
        get() = AppTheme.color.surface

    val ProgressColor
        @Composable
        get() = AppTheme.color.primary

    val BorderColor
        @Composable
        get() = AppTheme.color.border

    val BorderWidth
        @Composable
        get() = AppTheme.dimens.borderThin
}