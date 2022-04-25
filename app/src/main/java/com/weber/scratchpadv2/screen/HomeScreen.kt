package com.weber.scratchpadv2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.ScreenDestinations
import com.weber.scratchpadv2.components.BoxActionButton
import com.weber.scratchpadv2.components.NeoImageCirce
import com.weber.scratchpadv2.components.StartGameButton

/**
 * Начальный экран приложения
 */

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        NeoImageCirce(225.dp)
        Spacer(modifier = Modifier.size(30.dp))
        StartGameButton(stringResource(R.string.start), clickable = {
            navController.navigate(ScreenDestinations.PrepareGameSessionScreen.name)
        })
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.padding(start = 32.dp, end = 32.dp)) {
            val modifier = Modifier.weight(1F)
            BoxActionButton(
                modifier = modifier,
                drawableRes = R.drawable.ic_setting_start_screen,
                clickable = {
                    navController.navigate(ScreenDestinations.SettingScreen.name)
                }
            )
            Spacer(modifier = Modifier.size(48.dp))
            BoxActionButton(
                modifier = modifier,
                drawableRes = R.drawable.ic_start_screen_help_games,
                clickable = {
                    navController.navigate(ScreenDestinations.HintScreen.name)
                }
            )
        }
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "icon button"
        )
    }
}


