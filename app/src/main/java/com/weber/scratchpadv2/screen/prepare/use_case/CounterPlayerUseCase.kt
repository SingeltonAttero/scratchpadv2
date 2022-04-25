package com.weber.scratchpadv2.screen.prepare.use_case

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Количество игроков участвующих в игре
 */
class CounterPlayerUseCase {

    private val state = MutableStateFlow(MIN_COUNT_PLAYER)

    val players: StateFlow<Int>
        get() = state


    fun addPlayers(count: Int = 1) {
        if (state.value >= MAX_COUNT_PLAYER) return
        state.value = state.value + count
    }

    fun removePlayers(count: Int = 1) {
        if (state.value <= MIN_COUNT_PLAYER) return
        state.value = state.value - count
    }

    companion object {
        private const val MIN_COUNT_PLAYER = 3
        private const val MAX_COUNT_PLAYER = 15
    }
}