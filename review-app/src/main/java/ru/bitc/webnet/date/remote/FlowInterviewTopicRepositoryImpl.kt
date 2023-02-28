package ru.bitc.webnet.date.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.bitc.webnet.date.local.OpenAssetsFileProvider
import ru.bitc.webnet.date.remote.models.detailed.InterviewDetailedSubtopicDto
import ru.bitc.webnet.date.remote.models.ListFlowInterviewTopicDto
import ru.bitc.webnet.date.remote.models.detailed.QuestionDto
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import ru.bitc.webnet.domain.entity.FlowInterviewTopic
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailed
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailedList
import ru.bitc.webnet.domain.entity.detailed.Questions
import javax.inject.Inject

class FlowInterviewTopicRepositoryImpl @Inject constructor(
    private val openAssetsFileProvider: OpenAssetsFileProvider
) : FlowInterviewTopicRepository {

    private val jsonParser = Json


    override fun getInterviewTopic(): Flow<List<FlowInterviewTopic>> {
        return flow {
            val json = openAssetsFileProvider.getFileJson(INTERVIEW_TOPIC_JSON)
            val decodeToList = jsonParser.decodeFromString<ListFlowInterviewTopicDto>(json)
            emit(mapperDtoToListEntity(decodeToList))
        }
    }

    override fun getDetailedInterview(): Flow<List<InterviewDetailedList>> {
        return flow {
            val jsonString = openAssetsFileProvider.getFileJson(INTERVIEW_SUBTOPIC_JSON)
            val decodeFromString =
                jsonParser.decodeFromString<Map<String, List<InterviewDetailedSubtopicDto>>>(
                    jsonString
                )
            val entity = decodeFromString.map { (key, value) ->
                InterviewDetailedList(
                    key.toInt(),
                    value.map { subtopicDto ->
                        InterviewDetailed(
                            subtopicDto.questions.map { Questions(it.answers, it.quest) },
                            subtopicDto.subtopic
                        )
                    }
                )
            }.filter { it.interviewDetailed.isNotEmpty() }

            emit(entity)
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

    private companion object {
        const val INTERVIEW_TOPIC_JSON = "InterviewTopicList.json"
        const val INTERVIEW_SUBTOPIC_JSON = "InterviewDetailedList.json"
    }
}