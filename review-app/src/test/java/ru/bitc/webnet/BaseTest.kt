package ru.bitc.webnet

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

/**
 *
 */
abstract class BaseTest {


    @ExperimentalCoroutinesApi
    @BeforeEach
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @ExperimentalCoroutinesApi
    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    fun asyncTest(block: suspend () -> Unit) = runTest { block.invoke() }
}