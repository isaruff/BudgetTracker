package app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.focusable

import androidx.compose.runtime.Composable
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme

object NBFocusableContainerDefaults {

    val Shape
        @Composable
        get() = AppTheme.shapes.flat

    val BackgroundColor
        @Composable
        get() = AppTheme.color.surface

    val ContentColor
        @Composable
        get() = AppTheme.color.onSurface

    val BorderColor
        @Composable
        get() = AppTheme.color.outline

    val Elevation
        @Composable
        get() = AppTheme.dimens.cornerSm
}