package app.isaruff.budgettracker.presentation.ui_toolkit.components.item

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.static.NBContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import budgettracker.composeapp.generated.resources.Res
import budgettracker.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBListItem(
    headlineContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    overlineContent: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    verticalPadding: Dp = AppTheme.dimens.spacingSm,
    horizontalPadding: Dp = AppTheme.dimens.spacingMd,
    spacingBetween: Dp = AppTheme.dimens.spacingMd,
) {
    NBContainer(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingContent != null) {
                Box(modifier = Modifier.padding(end = spacingBetween)) {
                    leadingContent()
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = AppTheme.dimens.spacingXs),
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingXs)
            ) {
                if (overlineContent != null) {
                    ProvideTextStyle(AppTheme.typography.labelSmall) {
                        CompositionLocalProvider(LocalContentColor provides AppTheme.color.textSecondary) {
                            overlineContent()
                        }
                    }
                }

                ProvideTextStyle(AppTheme.typography.bodyLarge) {
                    CompositionLocalProvider(LocalContentColor provides AppTheme.color.textPrimary) {
                        headlineContent()
                    }
                }

                if (supportingContent != null) {
                    ProvideTextStyle(AppTheme.typography.bodySmall) {
                        CompositionLocalProvider(LocalContentColor provides AppTheme.color.textSecondary) {
                            supportingContent()
                        }
                    }
                }
            }

            if (trailingContent != null) {
                ProvideTextStyle(AppTheme.typography.bodySmall) {
                    CompositionLocalProvider(LocalContentColor provides AppTheme.color.textSecondary) {
                        Box(modifier = Modifier.padding(start = spacingBetween)) {
                            trailingContent()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun NBListItemPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBListItem(
                leadingContent = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(
                            Res.drawable.compose_multiplatform
                        ),
                        contentDescription = null
                    )
                },
                headlineContent = {
                    Text("Hello")
                },
                overlineContent = {
                    Text("Overline")
                },
                trailingContent = {
                    Text(
                        text = "Trailing Text"
                    )
                }
            )
        }
    }
}