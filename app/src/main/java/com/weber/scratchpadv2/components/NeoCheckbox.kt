package com.weber.scratchpadv2.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.components.core.neoCheckboxBottomShadow


@Composable
fun NeoCheckBox(selected: Boolean) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .size(30.dp)
            .neoCheckboxBottomShadow()
            .rotate(-45F),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(5.dp)
    ) {
        val color = if (selected) Color(0xFF7986CB) else Color(0x1A7986CB)

        Box(contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(15.dp), onDraw = {
                drawRoundRect(color, cornerRadius = CornerRadius(2.dp.toPx()))
                if (selected) {
                    drawRoundRect(
                        brush = Brush.verticalGradient(
                            startY = 3.dp.toPx(),
                            colors = listOf(
                                Color.White.copy(alpha = 0.2F),
                                Color.Black.copy(alpha = 0.4F)
                            )
                        ),
                        style = Stroke(2.dp.toPx()),
                        cornerRadius = CornerRadius(2.dp.toPx())
                    )
                } else {
                    drawRoundRect(
                        brush = Brush.verticalGradient(
                            startY = 3.dp.toPx(),
                            colors = listOf(
                                Color.Black.copy(alpha = 0.2F),
                                Color.White.copy(alpha = 0.4F),
                            )
                        ),
                        style = Stroke(2.dp.toPx()),
                        cornerRadius = CornerRadius(2.dp.toPx())
                    )
                }
            })

        }
    }
}