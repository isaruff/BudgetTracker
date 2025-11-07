package app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable

import androidx.compose.runtime.Composable
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme

object NBCLickableContainerDefaults {

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