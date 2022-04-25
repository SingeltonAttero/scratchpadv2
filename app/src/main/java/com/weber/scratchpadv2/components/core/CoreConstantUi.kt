package com.weber.scratchpadv2.components.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.ui.theme.NeoTopShadow

val NeoBorderGradient = BorderStroke(
    width = 1.dp,
    brush = Brush.linearGradient(
        colors = listOf(NeoTopShadow.copy(alpha = 0.5F), Color.Black.copy(alpha = 0.5F)),
        start = Offset(0F, 100F)
    )
)