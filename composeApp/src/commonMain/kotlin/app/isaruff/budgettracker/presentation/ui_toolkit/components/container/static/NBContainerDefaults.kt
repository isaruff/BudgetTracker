package app.isaruff.budgettracker.presentation.ui_toolkit.components.container.static

import androidx.compose.runtime.Composable
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme

object NBContainerDefaults {

    val Shape
        @Composable
        get() = AppTheme.shapes.medium

    val BackgroundColor
        @Composable
        get() = AppTheme.color.surface

    val ContentColor
        @Composable
        get() = AppTheme.color.onSurface

    val BorderColor
        @Composable
        get() = AppTheme.color.border

    val Elevation
        @Composable
        get() = AppTheme.dimens.cornerSm
}