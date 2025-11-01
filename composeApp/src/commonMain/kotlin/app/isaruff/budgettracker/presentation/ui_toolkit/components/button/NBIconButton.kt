package app.isaruff.budgettracker.presentation.ui_toolkit.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    tint: Color = AppTheme.color.onPrimary,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    NBClickableContainer(
        modifier = modifier,
        interactionSource = interactionSource,
        enabled = enabled,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier
                .padding(AppTheme.dimens.spacingSm)
                .size(AppTheme.dimens.iconSizeMd),
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