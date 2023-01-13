package ru.bitc.webnet.date.remote

import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.bitc.webnet.date.local.OpenAssetsFileProvider
import ru.bitc.webnet.date.remote.mock.FlowInterviewTopicMock
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import ru.bitc.webnet.BaseTest

internal class FlowInterviewTopicRepositoryImplTest : BaseTest() {

    private val openAssetsFileProvider = mockk<OpenAssetsFileProvider>()

    private lateinit var repository: FlowInterviewTopicRepository

    @BeforeEach
    fun init() {
        repository = FlowInterviewTopicRepositoryImpl(openAssetsFileProvider)
    }

    @Test
    fun `when get list flow interview topic should be return list interview topic entity`() {
        every { openAssetsFileProvider.getFileJson() } returns FlowInterviewTopicMock.listInterviewTopicJsonString
        asyncTest {
            repository.getInterviewTopic()
                .onEach { Assertions.assertEquals(it, FlowInterviewTopicMock.listInterviewTopic) }
                .collect()
        }
    }
}