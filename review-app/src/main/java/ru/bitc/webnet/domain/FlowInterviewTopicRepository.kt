package ru.bitc.webnet.domain

import kotlinx.coroutines.flow.Flow
import ru.bitc.webnet.domain.entity.FlowInterviewTopic
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailed
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailedList

interface FlowInterviewTopicRepository {
    fun getInterviewTopic(): Flow<List<FlowInterviewTopic>>

    fun getDetailedInterview(): Flow<List<InterviewDetailedList>>
}