package com.weber.scratchpadv2.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.weber.scratchpadv2.R

val Typography = Typography(

    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 56.sp,
        letterSpacing = 0.sp
    )
)