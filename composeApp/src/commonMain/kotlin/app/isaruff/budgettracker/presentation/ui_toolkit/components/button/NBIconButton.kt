package app.isaruff.budgettracker.presentation.ui_toolkit.components.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
    tint: Color = AppTheme.color.onPrimary,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f
    )
    Box(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(AppTheme.shapes.small)
            .border(
                width = AppTheme.dimens.borderThin,
                color = AppTheme.color.border
            )
            .padding(AppTheme.dimens.borderThin)
            .background(
                AppTheme.color.primary,
                shape = AppTheme.shapes.small
            )
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .padding(AppTheme.dimens.spacingSm)
                .size(AppTheme.dimens.iconSizeLg),
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