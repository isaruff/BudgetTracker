package app.isaruff.budgettracker.presentation.ui_toolkit.components.progressbar

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NBLinearProgressbar(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    shape: Shape = NBLinearProgressBarDefaults.Shape,
    stroke: Stroke = Stroke.Circle,
    trackColor: Color = NBLinearProgressBarDefaults.TrackColor,
    progressColor: Color = NBLinearProgressBarDefaults.ProgressColor,
    borderColor: Color = NBLinearProgressBarDefaults.BorderColor,
    borderWidth: Dp = NBLinearProgressBarDefaults.BorderWidth,
) {
    Canvas(
        modifier = modifier
            .height(NBLinearProgressBarDefaults.Height)
            .fillMaxWidth()
            .clip(shape)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = shape
            )
    ) {
        val progressValue = progress().coerceIn(0f, 1f)
        val innerCornerRadiusPx = stroke.toCornerRadiusDp().toPx()

        // Draw track (background)
        drawRoundRect(
            color = trackColor,
            topLeft = Offset(borderWidth.toPx(), borderWidth.toPx()),
            size = Size(
                width = size.width - (borderWidth.toPx() * 2),
                height = size.height - (borderWidth.toPx() * 2)
            ),
            cornerRadius = CornerRadius(innerCornerRadiusPx, innerCornerRadiusPx)
        )

        // Draw progress bar
        if (progressValue > 0f) {
            val progressWidth = (size.width - (borderWidth.toPx() * 2)) * progressValue

            drawRoundRect(
                color = progressColor,
                topLeft = Offset(borderWidth.toPx(), borderWidth.toPx()),
                size = Size(
                    width = progressWidth,
                    height = size.height - (borderWidth.toPx() * 2)
                ),
                cornerRadius = CornerRadius(innerCornerRadiusPx, innerCornerRadiusPx)
            )
        }
    }
}

enum class Stroke {
    Square,
    Circle;

    fun toCornerRadiusDp(): Dp {
        return when (this) {
            Square -> 0.dp
            Circle -> Int.MAX_VALUE.dp
        }
    }
}

@Preview
@Composable
private fun NBLinearProgressBarPrev() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize().systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            val infiniteTransition = rememberInfiniteTransition()
            val progress by infiniteTransition.animateFloat(
                initialValue = 0f, targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(3000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            NBLinearProgressbar(
                progress = { progress }
            )
        }
    }
}