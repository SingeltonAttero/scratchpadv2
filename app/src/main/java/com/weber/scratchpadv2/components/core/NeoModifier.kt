package com.weber.scratchpadv2.components.core

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.ui.theme.NeoTopShadow


/**
 * Создает светлую сторону тени
 * слева сверху круга
 * */
fun Modifier.neoCircleShadow(
    colorTop: Color = NeoTopShadow,
    colorBottom: Color = Color.Black,
    alpha: Float = 0.7F,
    shadowBlurRadius: Dp = 20.dp,
    offsetY: Dp = 16.dp,
    offsetX: Dp = 10.dp
): Modifier {
    return drawBehind {
        val shadowTopColor = colorTop.copy(alpha = alpha).toArgb()
        val transparentTopColor = colorTop.copy(alpha = 0f).toArgb()
        val shadowBottomColor = colorBottom.copy(alpha = alpha).toArgb()
        val transparentBottomColor = colorBottom.copy(alpha = 0f).toArgb()

        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentTopColor
            frameworkPaint.setShadowLayer(
                shadowBlurRadius.toPx(),
                -(offsetX + 3.dp).toPx(),
                -offsetY.toPx(),
                shadowTopColor
            )
            it.drawCircle(
                center = Offset(
                    x = this.size.width / 2,
                    y = this.size.height / 2
                ),
                radius = this.size.width / 2,
                paint = paint
            )
        }
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentBottomColor
            frameworkPaint.setShadowLayer(
                shadowBlurRadius.toPx(),
                (offsetX + 3.dp).toPx(),
                offsetY.toPx(),
                shadowBottomColor
            )
            it.drawCircle(
                center = Offset(
                    x = this.size.width / 2,
                    y = this.size.height / 2
                ),
                radius = this.size.width / 2,
                paint = paint
            )
        }
    }
}

/**
 * Создает тени в стиле neo
 * */
fun Modifier.neoRectangleBottomShadow(
    colorBottom: Color = Color.Black,
    colorTop: Color = NeoTopShadow,
    alpha: Float = 0.7f,
    shadowBlurRadius: Dp = 20.dp,
    offsetY: Dp = 4.dp,
    offsetX: Dp = 4.dp,
): Modifier {
    return drawBehind {
        val shadowTopColor = colorTop.copy(alpha = alpha).toArgb()
        val transparentTopColor = colorTop.copy(alpha = 0f).toArgb()
        val shadowBottomColor = colorBottom.copy(alpha = alpha).toArgb()
        val transparentBottomColor = colorBottom.copy(alpha = 0f).toArgb()

        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentBottomColor
            frameworkPaint.setShadowLayer(
                shadowBlurRadius.toPx(),
                (offsetX / 2).toPx(),
                (offsetY / 2).toPx(),
                shadowBottomColor
            )

            it.drawRect(
                Rect(
                    left = this.size.height / 30,
                    top = this.size.width / 20,
                    right = this.size.width + this.size.height / 20,
                    bottom = this.size.height + this.size.width / 30
                ), paint = paint
            )


        }
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentTopColor
            frameworkPaint.setShadowLayer(
                shadowBlurRadius.toPx(),
                -(offsetX / 2).toPx(),
                -(offsetY / 2).toPx(),
                shadowTopColor
            )

            it.drawRect(
                Rect(
                    left = 0F,
                    top = 0F,
                    right = this.size.width - this.size.height / 10,
                    bottom = this.size.height - this.size.width / 20
                ), paint = paint
            )


        }
    }
}

fun Modifier.neoCheckboxBottomShadow(
    colorBottom: Color = Color.Black,
    colorTop: Color = NeoTopShadow,
    alpha: Float = 0.7f,
    shadowBlurRadius: Dp = 5.dp,
    offsetY: Dp = 2.dp,
    offsetX: Dp = 2.dp,
): Modifier {
    return drawBehind {
        val shadowTopColor = colorTop.copy(alpha = alpha).toArgb()
        val transparentTopColor = colorTop.copy(alpha = 0f).toArgb()
        val shadowBottomColor = colorBottom.copy(alpha = alpha).toArgb()
        val transparentBottomColor = colorBottom.copy(alpha = 0f).toArgb()

        rotate(-45F) {
            drawIntoCanvas {
                val paint = Paint()
                val frameworkPaint = paint.asFrameworkPaint()
                frameworkPaint.color = transparentBottomColor
                frameworkPaint.setShadowLayer(
                    shadowBlurRadius.toPx(),
                    (offsetX / 2).toPx(),
                    (offsetY / 2).toPx(),
                    shadowBottomColor
                )

                it.drawRect(
                    Rect(
                        left = this.size.height / 30,
                        top = this.size.width / 20,
                        right = this.size.width + this.size.height / 20,
                        bottom = this.size.height + this.size.width / 30
                    ), paint = paint
                )


            }
            drawIntoCanvas {
                val paint = Paint()
                val frameworkPaint = paint.asFrameworkPaint()
                frameworkPaint.color = transparentTopColor
                frameworkPaint.setShadowLayer(
                    shadowBlurRadius.toPx(),
                    -(offsetX / 2).toPx(),
                    -(offsetY / 2).toPx(),
                    shadowTopColor
                )

                it.drawRect(
                    Rect(
                        left = 0F,
                        top = 0F,
                        right = this.size.width - this.size.height / 10,
                        bottom = this.size.height - this.size.width / 20
                    ), paint = paint
                )


            }
        }
    }
}

