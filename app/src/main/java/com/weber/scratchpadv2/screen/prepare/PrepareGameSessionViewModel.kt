package com.weber.scratchpadv2.screen.prepare

import androidx.lifecycle.ViewModel
import com.weber.scratchpadv2.screen.prepare.use_case.CounterPlayerUseCase
import com.weber.scratchpadv2.screen.prepare.use_case.CounterSpyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

}