package com.weber.scratchpadv2.screen.prepare

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.components.NeoSelector

/**
 * Предварительная настройка сессии игры
 */
@Composable
fun PrepareGameSessionScreen(
    modifier: Modifier,
    viewModel: PrepareGameSessionViewModel = hiltViewModel()
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val playerState = viewModel.playerSelectorState.collectAsState()
        val spyState = viewModel.spySelectorState.collectAsState()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = stringResource(id = R.string.prepare_game_session_title),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        NeoSelector(
            Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 8.dp),
            titleText = stringResource(R.string.counter_player_description),
            count = playerState.value.toString(),
            clickMinus = {
                viewModel.removePlayer()
            },
            clickPlus = {
                viewModel.addPlayer()
            }
        )
        NeoSelector(
            Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp),
            titleText = stringResource(R.string.counter_spy_description),
            count = spyState.value.toString(),
            clickMinus = {
                viewModel.removeSpy()
            },
            clickPlus = {
                viewModel.addSpy()
            }
        )
    }
}
