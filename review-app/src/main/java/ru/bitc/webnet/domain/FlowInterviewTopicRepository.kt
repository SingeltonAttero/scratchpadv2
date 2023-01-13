package ru.bitc.webnet.domain

import kotlinx.coroutines.flow.Flow
import ru.bitc.webnet.domain.entity.FlowInterviewTopic

interface FlowInterviewTopicRepository {
    fun getInterviewTopic(): Flow<List<FlowInterviewTopic>>
}