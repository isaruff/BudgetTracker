package app.isaruff.budgettracker.presentation.ui_toolkit.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBClickableContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {
    NBClickableContainer(
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(AppTheme.dimens.spacingSm),
            text = text,
            textAlign = TextAlign.Center,
            style = AppTheme.typography.labelLarge
        )
    }
}

@Preview
@Composable
private fun NBButtonPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBButton(
                modifier = Modifier.fillMaxWidth(0.8f),
                text = "Hello World",
                onClick = {}
            )
        }
    }
}