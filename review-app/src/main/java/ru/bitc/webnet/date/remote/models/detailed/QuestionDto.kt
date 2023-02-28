package ru.bitc.webnet.date.remote.models.detailed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionDto(
    @SerialName("answers")
    val answers: List<String>,
    @SerialName("quest")
    val quest: String
)