package app.isaruff.budgettracker.presentation.ui_toolkit.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBCLickableContainerDefaults
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBClickableContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import budgettracker.composeapp.generated.resources.Res
import budgettracker.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBIconButton(
    iconRes: DrawableResource,
    modifier: Modifier = Modifier,
    size: Dp = AppTheme.dimens.iconSizeMd,
    tint: Color = AppTheme.color.onSurface,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = NBCLickableContainerDefaults.Shape,
    background: Color = NBCLickableContainerDefaults.BackgroundColor,
    borderColor: Color = NBCLickableContainerDefaults.BorderColor,
    contentColor: Color = NBCLickableContainerDefaults.ContentColor,
    elevation: Dp = NBCLickableContainerDefaults.Elevation,
    contentPaddingValues: PaddingValues = PaddingValues(AppTheme.dimens.spacingXs),
    onClick: () -> Unit,
) {
    NBClickableContainer(
        modifier = modifier,
        shape = shape,
        background = background,
        borderColor = borderColor,
        contentColor = contentColor,
        elevation = elevation,
        interactionSource = interactionSource,
        enabled = enabled,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier
                .padding(contentPaddingValues)
                .size(size),
            painter = painterResource(iconRes),
            tint = tint,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun NBIconButtonPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBIconButton(
                iconRes = Res.drawable.compose_multiplatform,
                onClick = {}
            )
        }
    }
}