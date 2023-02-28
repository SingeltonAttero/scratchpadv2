package ru.bitc.webnet.date.remote.models.detailed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InterviewDetailedSubtopicDto(
    @SerialName("questions")
    val questions: List<QuestionDto>,
    @SerialName("subtopic")
    val subtopic: String
)