package app.isaruff.budgettracker.presentation.ui_toolkit.components.container.clickable

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateIntOffset
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.modifier.noRippleClickable
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBClickableContainer(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    shape: Shape = NBCLickableContainerDefaults.Shape,
    background: Color = NBCLickableContainerDefaults.BackgroundColor,
    borderColor: Color = NBCLickableContainerDefaults.BorderColor,
    contentColor: Color = NBCLickableContainerDefaults.ContentColor,
    elevation: Dp = NBCLickableContainerDefaults.Elevation,
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
                elevation
            }
        }
    )
    val contentOffset by transition.animateIntOffset(
        targetValueByState = { state ->
            val pressedOffsetPx = with(density) {
                elevation.roundToPx()
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
                shape = shape,
                shadow = Shadow(
                    radius = AppTheme.dimens.elevationFlat,
                    spread = AppTheme.dimens.elevationFlat,
                    color = borderColor,
                    offset = DpOffset(shadowOffset, shadowOffset)
                )
            )
            .border(
                width = AppTheme.dimens.cornerSm,
                color = borderColor,
                shape = shape
            )
            .padding(AppTheme.dimens.cornerSm)
            .background(
                color = background
            )
            .noRippleClickable(
                enabled = enabled,
                interactionSource = interactionSource,
                onClick = onClick
            ),
        content = {
            CompositionLocalProvider(
                LocalContentColor provides contentColor
            ) {
                content()
            }
        }
    )
}

@Preview(showBackground = true)
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
