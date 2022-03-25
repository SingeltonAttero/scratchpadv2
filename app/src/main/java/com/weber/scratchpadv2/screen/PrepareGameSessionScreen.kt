package com.weber.scratchpadv2.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Предварительная настройка сессии игры
 * Created on 25.03.2022
 * @author YWeber
 */
@Composable
fun PrepareGameSessionScreen(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Test text screen")
    }
}
