package app.isaruff.budgettracker.presentation.ui_toolkit.components.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.static.NBContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import budgettracker.composeapp.generated.resources.Res
import budgettracker.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBIcon(
    iconRes: DrawableResource,
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.color.onSurface,
    background: Color = AppTheme.color.surface,
    size: Dp = AppTheme.dimens.iconSizeLg,
    contentPadding: Dp = AppTheme.dimens.spacingXs,
    contentDescription: String? = null
) {
    NBContainer(
        modifier = modifier,
        background = background,
        contentColor = tint,
        elevation = AppTheme.dimens.elevationFlat
    ) {
        Icon(
            modifier = Modifier
                .padding(contentPadding)
                .size(size)
                .align(Alignment.Center),
            painter = painterResource(iconRes),
            contentDescription = contentDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NBIconPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            NBIcon(
                iconRes = Res.drawable.compose_multiplatform
            )
        }
    }
}
