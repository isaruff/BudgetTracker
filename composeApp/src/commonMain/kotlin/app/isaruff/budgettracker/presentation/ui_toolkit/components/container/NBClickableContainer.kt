package app.isaruff.budgettracker.presentation.ui_toolkit.components.container

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateIntOffset
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBClickableContainer(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val density = LocalDensity.current
    val isPressed by interactionSource.collectIsPressedAsState()
    val transition = updateTransition(isPressed)
    val shadowOffset by transition.animateDp(
        targetValueByState = { state ->
            if (state) {
                AppTheme.dimens.elevationFlat
            } else {
                AppTheme.dimens.cornerSm
            }
        }
    )
    val contentOffset by transition.animateIntOffset(
        targetValueByState = { state ->
            val pressedOffsetPx = with(density) {
                AppTheme.dimens.cornerSm.roundToPx()
            }
            val restOffsetPx = with(density) {
                AppTheme.dimens.elevationFlat.roundToPx()
            }
            if (state) {
                IntOffset(pressedOffsetPx, pressedOffsetPx)
            } else {
                IntOffset(restOffsetPx, restOffsetPx)
            }
        }
    )
    Box(
        modifier = modifier
            .offset { contentOffset }
            .dropShadow(
                shape = AppTheme.shapes.medium,
                shadow = Shadow(
                    radius = AppTheme.dimens.elevationFlat,
                    spread = AppTheme.dimens.elevationFlat,
                    color = AppTheme.color.border,
                    offset = DpOffset(shadowOffset, shadowOffset)
                )
            )
            .border(
                width = AppTheme.dimens.cornerSm,
                color = Color.Black,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimens.cornerSm)
            .background(
                color = AppTheme.color.accent,
                shape = AppTheme.shapes.small
            )
            .clickable(
                indication = null,
                enabled = enabled,
                interactionSource = interactionSource,
                onClick = onClick
            ),
        content = content
    )
}

@Preview
@Composable
private fun NBClickableContainerPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBClickableContainer(
                onClick = {}
            ) {
                Box(
                    modifier = Modifier.size(100.dp, 80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hello World",
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}
