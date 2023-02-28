package ru.bitc.webnet.date.remote

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.bitc.webnet.BaseTest
import ru.bitc.webnet.date.local.OpenAssetsFileProvider
import ru.bitc.webnet.date.remote.mock.FlowInterviewTopicMock
import ru.bitc.webnet.date.remote.mock.InterviewDetailedMock
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import kotlin.properties.Delegates

internal class FlowInterviewTopicRepositoryImplTest : BaseTest() {

    private val openAssetsFileProvider = mockk<OpenAssetsFileProvider>()

    private var repository by Delegates.notNull<FlowInterviewTopicRepository>()

    @BeforeEach
    fun init() {
        repository = FlowInterviewTopicRepositoryImpl(openAssetsFileProvider)
    }

    @Test
    fun `when get list flow interview topic should be return list interview topic entity`() {
        every { openAssetsFileProvider.getFileJson(any()) } returns FlowInterviewTopicMock.LIST_INTERVIEW_TOPIC_JSON_STRING
        asyncTest {
            repository.getInterviewTopic()
                .onEach { Assertions.assertEquals(it, FlowInterviewTopicMock.listInterviewTopic) }
                .collect()
        }

        verifySequence { openAssetsFileProvider.getFileJson(any()) }
        confirmVerified()
    }

    @Test
    fun `when get interview detailed questions should be return list interview detailed entity list`() {
        every { openAssetsFileProvider.getFileJson(any()) } returns InterviewDetailedMock.INTERVIEW_DETAILED_JSON
        asyncTest {
            repository.getDetailedInterview().onEach {
                Assertions.assertEquals(it, InterviewDetailedMock.interviewDetailedList)

            }
        }
    }
}