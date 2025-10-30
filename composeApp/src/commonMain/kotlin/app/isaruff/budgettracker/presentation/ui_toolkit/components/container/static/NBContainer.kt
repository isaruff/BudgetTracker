package app.isaruff.budgettracker.presentation.ui_toolkit.components.container.static

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.static.NBContainerDefaults
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBContainer(
    modifier: Modifier = Modifier,
    shape: Shape = NBContainerDefaults.Shape,
    background: Color = NBContainerDefaults.BackgroundColor,
    borderColor: Color = NBContainerDefaults.BorderColor,
    contentColor: Color = NBContainerDefaults.ContentColor,
    elevation: Dp = NBContainerDefaults.Elevation,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .dropShadow(
                shape = shape,
                shadow = Shadow(
                    radius = AppTheme.dimens.elevationFlat,
                    spread = AppTheme.dimens.elevationFlat,
                    color = borderColor,
                    offset = DpOffset(elevation, elevation)
                )
            )
            .border(
                width = AppTheme.dimens.cornerSm,
                color = borderColor,
                shape = shape
            )
            .padding(AppTheme.dimens.cornerSm)
            .background(
                color = background,
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
private fun NBContainerPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBContainer {
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

