package com.weber.scratchpadv2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.components.core.NeoBorderGradient
import com.weber.scratchpadv2.components.core.neoCircleShadow

/**
 * Компонент с тенями в стиле неоконформизма
 */


@Composable
fun NeoImageCirce(size: Dp = 275.dp) {
    Box(
        modifier = Modifier
            .padding(top = 34.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Surface(
            modifier = Modifier
                .size(size = size)
                .neoCircleShadow(),
            border = NeoBorderGradient,
            color = Color(0xFF1D2862),
            shape = CircleShape,
        ) {
            Image(
                modifier = Modifier.padding(48.dp),
                painter = painterResource(id = R.drawable.ic_spy_main_logo),
                contentDescription = "spy logo"
            )
        }
    }
}
