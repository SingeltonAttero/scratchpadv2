package com.weber.scratchpadv2.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
 * Начальный экран приложения
 * Created on 18.01.2022
 * @author YWeber
 */

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StartButton(title = stringResource(R.string.start))
            StartButton(title = stringResource(R.string.other_games))
            StartButton(title = stringResource(R.string.setting))
        }
    }
}

@Composable
fun StartButton(title: String, clickable: () -> Unit = {}) {
    Text(
        text = title,
        style = MaterialTheme.typography.h3,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .clickable {
                clickable.invoke()
            }
            .fillMaxWidth()
            .padding(16.dp)
    )
}


