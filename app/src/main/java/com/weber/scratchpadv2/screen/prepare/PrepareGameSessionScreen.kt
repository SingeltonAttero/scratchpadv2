package com.weber.scratchpadv2.screen.prepare

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.components.NeoCheckBox
import com.weber.scratchpadv2.components.NeoSelector
import com.weber.scratchpadv2.components.core.neoRectangleBottomShadow
import com.weber.scratchpadv2.screen.prepare.state.LocationState
import com.weber.scratchpadv2.ui.theme.DarkBackgroundHomeScreen

/**
 * Предварительная настройка сессии игры
 */
@Composable
fun PrepareGameSessionScreen(
    modifier: Modifier,
    viewModel: PrepareGameSessionViewModel = hiltViewModel()
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val playerState by viewModel.playerSelectorState.collectAsState()
        val spyState by viewModel.spySelectorState.collectAsState()
        val locationState by viewModel.locationState.collectAsState()
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
            count = playerState.toString(),
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
            count = spyState.toString(),
            clickMinus = {
                viewModel.removeSpy()
            },
            clickPlus = {
                viewModel.addSpy()
            }
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            text = stringResource(id = R.string.title_location),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
        GroupCheckboxLocation(locationState, viewModel)

        Row() {

        }

    }
}

@Composable
private fun ColumnScope.GroupCheckboxLocation(
    locationState: List<LocationState>,
    viewModel: PrepareGameSessionViewModel
) {
    LazyColumn(
        modifier = Modifier.Companion
            .weight(1F)
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
    ) {
        locationState.chunked(2).forEach { groupList ->
            item {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    groupList.forEach() { location ->
                        Surface(
                            color = MaterialTheme.colors.background,
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .weight(1F)
                                .padding(start = 8.dp, top = 16.dp)
                        ) {
                            Row(
                                modifier = Modifier.clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(
                                        color = DarkBackgroundHomeScreen
                                    )
                                ) {
                                    viewModel.selectLocation(location)
                                },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                NeoCheckBox(location.isChecked)
                                Text(text = location.title)
                            }
                        }
                    }
                }
            }
        }

    }
}
