package com.weber.scratchpadv2.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.R

/**
 * Предварительная настройка сессии игры
 * Created on 25.03.2022
 * @author YWeber
 */
@Composable
fun PrepareGameSessionScreen(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.TopCenter) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            text = stringResource(id = R.string.prepare_game_session_title),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
    }
}
