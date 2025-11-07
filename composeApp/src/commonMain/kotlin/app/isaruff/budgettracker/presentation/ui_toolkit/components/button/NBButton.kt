package app.isaruff.budgettracker.presentation.ui_toolkit.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBCLickableContainerDefaults
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.clickable.NBClickableContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = NBCLickableContainerDefaults.Shape,
    background: Color = NBCLickableContainerDefaults.BackgroundColor,
    borderColor: Color = NBCLickableContainerDefaults.BorderColor,
    contentColor: Color = NBCLickableContainerDefaults.ContentColor,
    elevation: Dp = NBCLickableContainerDefaults.Elevation,
    content: @Composable RowScope.() -> Unit
) {
    NBClickableContainer(
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        background = background,
        borderColor = borderColor,
        contentColor = contentColor,
        elevation = elevation,
        onClick = onClick,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    )
}

@Composable
private fun NBButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = NBCLickableContainerDefaults.Shape,
    background: Color = NBCLickableContainerDefaults.BackgroundColor,
    borderColor: Color = NBCLickableContainerDefaults.BorderColor,
    contentColor: Color = NBCLickableContainerDefaults.ContentColor,
    elevation: Dp = NBCLickableContainerDefaults.Elevation
) {
    NBButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        background = background,
        borderColor = borderColor,
        contentColor = contentColor,
        elevation = elevation,
    ) {
        Text(
            modifier = Modifier
                .padding(AppTheme.dimens.spacingSm),
            text = text,
            textAlign = TextAlign.Center,
            style = AppTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
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