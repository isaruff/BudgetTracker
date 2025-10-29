package app.isaruff.budgettracker.presentation.ui_toolkit.components.container

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateIntOffset
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBFocusableContainer(
    interactionSource: MutableInteractionSource,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val density = LocalDensity.current
    val isFocused by interactionSource.collectIsFocusedAsState()
    val transition = updateTransition(isFocused)
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
                color = AppTheme.color.border,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimens.cornerSm)
            .background(
                color = AppTheme.color.secondary,
                shape = AppTheme.shapes.small
            ),
        content = content
    )
}

@Preview(showBackground = true)
@Composable
private fun NBFocusableContainerPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            val interactionSource = remember { MutableInteractionSource() }
            NBFocusableContainer(
                interactionSource = interactionSource
            ) {
                BasicTextField(
                    modifier = Modifier.padding(AppTheme.dimens.spacingMd),
                    value = "Hello world",
                    onValueChange = {},
                    interactionSource = interactionSource
                )
            }
        }
    }
}