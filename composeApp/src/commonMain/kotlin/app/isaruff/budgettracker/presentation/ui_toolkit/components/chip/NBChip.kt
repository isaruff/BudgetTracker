package app.isaruff.budgettracker.presentation.ui_toolkit.components.chip

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBClickableContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBChip(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentPadding: PaddingValues = PaddingValues(AppTheme.dimens.spacingSm),
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) {
    NBClickableContainer(
        modifier = modifier,
        enabled = onClick != null,
        background = backgroundColor,
        elevation = AppTheme.dimens.elevationFlat,
        onClick = { onClick?.invoke() },
        content = {
            ProvideTextStyle(
                AppTheme.typography.labelMedium
            ) {
                Row(
                    modifier = Modifier.padding(contentPadding),
                    content = content
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun NBChipPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingMd)
            ) {
                repeat(2) { index ->
                    val color = if (index == 0) AppTheme.color.secondary else AppTheme.color.primary
                    NBChip(
                        backgroundColor = color,
                        content = {
                            Text(
                                text = "Hello World"
                            )
                        },
                        onClick = {}
                    )
                }
            }
        }
    }
}