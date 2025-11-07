package app.isaruff.budgettracker.presentation.ui_toolkit.components.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import app.isaruff.budgettracker.presentation.ui_toolkit.components.button.NBIconButton
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import budgettracker.composeapp.generated.resources.Res
import budgettracker.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBSingleRowTopBar(
    modifier: Modifier = Modifier,
    title: @Composable RowScope.() -> Unit,
    navigationIcon: (@Composable RowScope.() -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .defaultMinSize(
                minHeight = AppTheme.dimens.containerSizeMd
            )
            .drawUnderline(
                borderColor = AppTheme.color.outline,
                borderWidthPx = 10f
            )
            .statusBarsPadding()
            .padding(AppTheme.dimens.spacingSm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (navigationIcon != null) {
            ContentColorProvider {
                navigationIcon()
            }
            Spacer(Modifier.width(AppTheme.dimens.spacingMd))
        }
        TitleTextProvider {
            title()
        }
        Spacer(Modifier.width(AppTheme.dimens.spacingMd))
        Spacer(Modifier.weight(1f))
        if (actions != null) {
            ContentColorProvider {
                actions()
            }
        }
    }
}

@Composable
private fun TitleTextProvider(content: @Composable () -> Unit) {
    ProvideTextStyle(
        value = AppTheme.typography.displaySmall.copy(
            color = AppTheme.color.onBackground
        ),
        content = content
    )
}

@Composable
private fun ContentColorProvider(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        value = LocalContentColor provides AppTheme.color.onBackground,
        content = content
    )
}

private fun Modifier.drawUnderline(
    borderColor: Color,
    borderWidthPx: Float
): Modifier = drawBehind {
    drawLine(
        color = borderColor,
        strokeWidth = borderWidthPx,
        start = Offset(x = 0f, y = size.height),
        end = Offset(x = size.width, y = size.height)
    )
}

@Preview(showBackground = true)
@Composable
private fun NBSingleRowTopBarPrev() {
    AppTheme {
        Scaffold(
            topBar = {
                NBSingleRowTopBar(
                    navigationIcon = {
                        NBIconButton(
                            iconRes = Res.drawable.compose_multiplatform,
                            onClick = {}
                        )
                    },
                    title = {
                        Text(
                            text = "Hello world"
                        )
                    }
                )

            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(it)
                    .background(Color.Cyan)
            )
        }
    }
}