package ru.bitc.webnet.ui.screens.flow

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.bitc.webnet.BaseTest
import ru.bitc.webnet.date.remote.mock.FlowInterviewTopicMock
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import ru.bitc.webnet.ui.screens.flow.mock.FlowInterviewTopicUIMock

internal class FlowInteractionViewModelTest : BaseTest() {

    private val flowInterviewTopicRepository = mockk<FlowInterviewTopicRepository>() {
        coEvery { getInterviewTopic() } returns flowOf(
            FlowInterviewTopicMock.listInterviewTopic
        )
    }


    private lateinit var viewModel: FlowInteractionViewModel


    @BeforeEach
    fun init() {
        viewModel = FlowInteractionViewModel(flowInterviewTopicRepository)
    }


    @Test
    fun `when invoke open asset file method should be return new uiState`() {
        val expected = viewModel.uiState.value
        Assertions.assertEquals(expected, FlowInterviewTopicUIMock.FlowInterviewTopicList)
    }
}