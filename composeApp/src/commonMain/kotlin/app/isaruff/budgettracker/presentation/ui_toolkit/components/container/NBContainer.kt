package app.isaruff.budgettracker.presentation.ui_toolkit.components.container

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBContainer(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .dropShadow(
                shape = AppTheme.shapes.medium,
                shadow = Shadow(
                    radius = AppTheme.dimens.elevationFlat,
                    spread = AppTheme.dimens.elevationFlat,
                    color = AppTheme.color.border,
                    offset = NBContainerDefaults.ShadowOffset
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
            ),
        content = content
    )
}

object NBContainerDefaults {
    val ShadowOffset
        @Composable
        get() = DpOffset(AppTheme.dimens.cornerSm, AppTheme.dimens.cornerSm)

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

