package ru.bitc.webnet.date.remote.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FlowInterviewTopicDto(
    @SerialName("id")
    val id: String,
    @SerialName("position")
    val position: String,
    @SerialName("categoryDifficulty")
    val categoryDifficulty: String,
    @SerialName("topicList")
    val topics: List<String>,
    @SerialName("maxQuestion")
    val maxQuestion: Int,
    @SerialName("time")
    val time: String,
)