package ru.bitc.webnet.date.remote.models

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class ListFlowInterviewTopicDto(
    @SerialName("interviewTopic")
    val interviewTopic: List<FlowInterviewTopicDto>
)