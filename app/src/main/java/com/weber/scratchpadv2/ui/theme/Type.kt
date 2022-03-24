package com.weber.scratchpadv2.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(

    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 70.sp,
        letterSpacing = 1.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        color = AppButtonTextColor,
        fontSize = 56.sp,
        letterSpacing = 0.sp
    )
)