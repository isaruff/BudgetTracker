package app.isaruff.budgettracker.presentation.ui_toolkit.components.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.static.NBContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun NBIcon(
    iconRes: DrawableResource,
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.color.onSurface,
    background: Color = AppTheme.color.surface,
    size: Dp = AppTheme.dimens.iconSizeMd,
) {
    NBContainer(modifier = modifier) {  }
}
