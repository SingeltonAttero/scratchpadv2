package com.weber.scratchpadv2.screen.prepare

import androidx.lifecycle.ViewModel
import com.weber.scratchpadv2.screen.prepare.state.LocationState
import com.weber.scratchpadv2.screen.prepare.use_case.CounterPlayerUseCase
import com.weber.scratchpadv2.screen.prepare.use_case.CounterSpyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Предварительная настройка сессии игры
 */
@HiltViewModel
class PrepareGameSessionViewModel @Inject constructor(
    private val counterPlayerUseCase: CounterPlayerUseCase,
    private val counterSpyUseCase: CounterSpyUseCase
) : ViewModel() {

    val playerSelectorState = counterPlayerUseCase.players
    val spySelectorState = counterSpyUseCase.spyState
    private val _locationState: MutableStateFlow<List<LocationState>> = MutableStateFlow(
        listOf(
            LocationState(title = "Город", isChecked = true),
            LocationState(title = "Фантастика", isChecked = false),
            LocationState(title = "Природа", isChecked = false),
            LocationState(title = "Путешествия", isChecked = false),
            LocationState(title = "Планеты", isChecked = false),
            LocationState(title = "История", isChecked = false),
        )
    )
    val locationState: StateFlow<List<LocationState>>
        get() = _locationState

    fun addPlayer() {
        counterPlayerUseCase.addPlayers()
        counterSpyUseCase.defaultSpy(playerSelectorState.value)
    }

    fun removePlayer() {
        counterPlayerUseCase.removePlayers()
        counterSpyUseCase.defaultSpy(playerSelectorState.value)
    }

    fun addSpy() {
        counterSpyUseCase.addSpy(playerSelectorState.value)
    }

    fun removeSpy() {
        counterSpyUseCase.removeSpy()
    }

    fun selectLocation(locationState: LocationState) {
        val newLocationState = _locationState.value.map { localLocationState ->
            if (locationState == localLocationState) {
                localLocationState.copy(isChecked = !localLocationState.isChecked)
            } else {
                localLocationState
            }
        }
        _locationState.value = newLocationState
    }

}