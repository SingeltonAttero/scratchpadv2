package ru.bitc.webnet.date.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.bitc.webnet.date.local.OpenAssetsFileProvider
import ru.bitc.webnet.date.remote.models.ListFlowInterviewTopicDto
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import ru.bitc.webnet.domain.entity.FlowInterviewTopic
import javax.inject.Inject

class FlowInterviewTopicRepositoryImpl @Inject constructor(
    private val openAssetsFileProvider: OpenAssetsFileProvider
) : FlowInterviewTopicRepository {

    private val jsonParser = Json


    override fun getInterviewTopic(): Flow<List<FlowInterviewTopic>> {
        return flow {
            val json = openAssetsFileProvider.getFileJson()
            val decodeFromString = jsonParser.decodeFromString<ListFlowInterviewTopicDto>(json)
            emit(mapperDtoToListEntity(decodeFromString))
        }
    }

    private fun mapperDtoToListEntity(dto: ListFlowInterviewTopicDto): List<FlowInterviewTopic> {
        return dto.interviewTopic.map {
            FlowInterviewTopic(
                id = it.id,
                position = it.position,
                categoryDifficulty = it.categoryDifficulty,
                topics = it.topics,
                maxQuestion = it.maxQuestion,
                time = it.time
            )
        }
    }
}