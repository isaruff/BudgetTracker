package app.isaruff.budgettracker.presentation.ui_toolkit.components.bottombar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import app.isaruff.budgettracker.presentation.ui_toolkit.components.bottombar.ItemPosition.Companion.getPosition
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import budgettracker.composeapp.generated.resources.Res
import budgettracker.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBBottomBar(
    selected: NBBottomBarItem,
    items: List<NBBottomBarItem>,
    modifier: Modifier = Modifier,
    onSelect: (id: String) -> Unit
) {
    Row(
        modifier = modifier.drawTopBorder(
            color = AppTheme.color.border,
        )
    ) {
        items.forEachIndexed { index, item ->
            val position = items.getPosition(index)
            Item(
                modifier = Modifier
                    .weight(1f)
                    .drawItemDivider(
                        itemPosition = position,
                        color = AppTheme.color.border
                    ),
                isSelected = item == selected,
                data = item,
                onClick = { onSelect(it.id) }
            )
        }
    }
}

@Composable
private fun Item(
    isSelected: Boolean,
    data: NBBottomBarItem,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: (NBBottomBarItem) -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) data.accent else AppTheme.color.background
    )
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.25f else 1f
    )
    Box(
        modifier = modifier
            .background(
                color = backgroundColor
            )
            .clickable(
                enabled = enabled,
                onClick = { onClick(data) }
            )
            .padding(AppTheme.dimens.spacingMd),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .graphicsLayer {
                    scaleX *= scale
                    scaleY *= scale
                }
                .size(AppTheme.dimens.iconSizeMd),
            painter = painterResource(data.icon),
            tint = data.tint,
            contentDescription = "AA"
        )
    }
}

fun Modifier.drawTopBorder(
    color: Color,
    strokeWidth: Float = 10f
): Modifier = drawBehind {
    drawLine(
        color = color,
        start = Offset(x = 0f, y = 0f),
        end = Offset(x = size.width, y = 0f),
        strokeWidth = strokeWidth
    )
}

fun Modifier.drawItemDivider(
    itemPosition: ItemPosition,
    color: Color,
    strokeWidth: Float = 10f
): Modifier = drawBehind {
    if (itemPosition == ItemPosition.Single) return@drawBehind

    val shouldDrawStart =
        itemPosition == ItemPosition.Middle || itemPosition == ItemPosition.End || itemPosition == ItemPosition.Start
    if (shouldDrawStart) {
        drawLine(
            color = color,
            strokeWidth = strokeWidth,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 0f, y = size.height)
        )
    }
}


@Preview
@Composable
private fun ItemPrev() {
    AppTheme {
        Item(
            isSelected = true,
            data = NBBottomBarItem(
                id = "id",
                icon = Res.drawable.compose_multiplatform,
                tint = AppTheme.color.onBackground,
                accent = AppTheme.color.accent
            ),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NBBottomBarPrev() {
    AppTheme {
        val items = prevItems
        var selected by remember {
            mutableStateOf(items[0])
        }
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            NBBottomBar(
                selected = selected,
                items = items,
                onSelect = { id ->
                    selected = items.first { it.id == id }
                }
            )
        }

    }
}

private val prevItems
    @Composable
    get() = listOf(
        NBBottomBarItem(
            id = "f",
            icon = Res.drawable.compose_multiplatform,
            tint = AppTheme.color.onBackground,
            accent = AppTheme.color.primary
        ),
        NBBottomBarItem(
            id = "a",
            icon = Res.drawable.compose_multiplatform,
            tint = AppTheme.color.onBackground,
            accent = AppTheme.color.accent
        ),
        NBBottomBarItem(
            id = "b",
            icon = Res.drawable.compose_multiplatform,
            tint = AppTheme.color.onBackground,
            accent = AppTheme.color.secondary
        ),
        NBBottomBarItem(
            id = "c",
            icon = Res.drawable.compose_multiplatform,
            tint = AppTheme.color.onBackground,
            accent = AppTheme.color.error
        )
    )