package app.isaruff.budgettracker.presentation.ui_toolkit.components.bottombar

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class NBBottomBarItem(
    val id: String,
    val icon: DrawableResource,
    val tint: Color,
    val accent: Color
)