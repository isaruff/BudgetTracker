package app.isaruff.budgettracker.presentation.model

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class IconUiModel(
    val icon: DrawableResource,
    val tint: Color,
    val backgroundColor: Color
)
