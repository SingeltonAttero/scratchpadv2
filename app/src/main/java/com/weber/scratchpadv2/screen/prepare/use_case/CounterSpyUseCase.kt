package com.weber.scratchpadv2.screen.prepare.use_case

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Количество шпионов в игре
 */
class CounterSpyUseCase {

    private val state = MutableStateFlow(1)

    val spyState: StateFlow<Int>
        get() = state

    fun addSpy(countPlayer: Int, countSpy: Int = 1) {
        if ((countPlayer - 2) <= state.value) return
        state.value = state.value + countSpy
    }

    fun removeSpy(countSpy: Int = 1) {
        if (state.value <= 1) return
        state.value = state.value - countSpy
    }

    fun defaultSpy(countPlayer: Int) {
        val countSpy = when {
            countPlayer <= 3 -> 1
            countPlayer in 4..5 -> 2
            countPlayer in 7..8 -> 3
            countPlayer in 9..10 -> 4
            countPlayer == 11 -> 5
            countPlayer in 12..14 -> 6
            countPlayer == 15 -> 7
            else -> countPlayer / 3
        }

        state.value = countSpy
    }

}