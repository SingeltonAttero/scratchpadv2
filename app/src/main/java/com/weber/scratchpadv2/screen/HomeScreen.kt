package com.weber.scratchpadv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.components.HomeButton
import com.weber.scratchpadv2.components.TitleStartApp

/**
 * Начальный экран приложения
 * Created on 18.01.2022
 * @author YWeber
 */

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(1.dp, 80.dp))
            TitleStartApp(modifier = Modifier.padding(bottom = 40.dp))
            HomeButton(title = stringResource(R.string.start))
            HomeButton(title = stringResource(R.string.setting))
        }
    }
}


