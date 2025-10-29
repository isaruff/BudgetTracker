package app.isaruff.budgettracker.presentation.ui_toolkit.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.NBFocusableContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NeobrutalistTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = AppTheme.typography.bodyMedium,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingSm)
    ) {
        if (label != null) {
            LabelStyleProvider(label)
        }
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = AppTheme.dimens.iconSizeLg),
            value = value,
            onValueChange = onValueChange,
            visualTransformation = visualTransformation,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            readOnly = readOnly,
            textStyle = textStyle,
            maxLines = maxLines,
            singleLine = singleLine,
            minLines = minLines,
            interactionSource = interactionSource,
            enabled = enabled,
            decorationBox = { innerTextField ->
                NBFocusableContainer(
                    modifier = Modifier.fillMaxWidth(),
                    interactionSource = interactionSource
                ) {
                    TextStyleProvider {
                        Row(modifier = Modifier.padding(AppTheme.dimens.spacingSm)) {
                            if (leadingIcon != null) {
                                leadingIcon()
                            }
                            if (prefix != null) {
                                prefix()
                            }
                            Box(
                                modifier = Modifier.weight(1f)
                            ) {
                                if (value.isBlank() && placeholder != null) {
                                    TextStyleProvider(placeholder)
                                }
                                innerTextField()
                            }
                            if (suffix != null) {
                                suffix()
                            }
                            if (trailingIcon != null) {
                                trailingIcon()
                            }
                        }
                    }
                }
            }
        )
        if (supportingText != null) {
            SupportingTextProvider(supportingText)
        }
    }
}

@Composable
private fun SupportingTextProvider(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTextStyle provides AppTheme.typography.labelLarge
    ) {
        content()
    }
}

@Composable
private fun LabelStyleProvider(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTextStyle provides AppTheme.typography.labelMedium
    ) {
        content()
    }
}

@Composable
private fun TextStyleProvider(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTextStyle provides AppTheme.typography.bodyMedium
    ) {
        content()
    }
}


// Preview Examples
@Preview(showBackground = true)
@Composable
fun NeobrutalistTextFieldExamples() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("Sample text") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }

    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                "Neobrutalist TextField Examples",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )

            // Basic TextField
            NeobrutalistTextField(
                value = text1,
                onValueChange = { text1 = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                singleLine = true
            )

            // TextField with Icons
            NeobrutalistTextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("Username") },
                leadingIcon = { Text("@") },
                trailingIcon = { Text("✓") },
                singleLine = true
            )

            // Multiline TextField
            NeobrutalistTextField(
                value = text3,
                onValueChange = { text3 = it },
                label = { Text("Description") },
                placeholder = { Text("Write something...") },
                minLines = 4,
                maxLines = 6,
                supportingText = { Text("${text3.length}/500 characters") }
            )

            // Error State
            NeobrutalistTextField(
                value = text4,
                onValueChange = { text4 = it },
                label = { Text("Password") },
                placeholder = { Text("Enter password") },
                isError = text4.length < 8 && text4.isNotEmpty(),
                supportingText = {
                    if (text4.length < 8 && text4.isNotEmpty()) {
                        Text("Password must be at least 8 characters")
                    }
                },
                singleLine = true,
                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
            )
        }
    }
}