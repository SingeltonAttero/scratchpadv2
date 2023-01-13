package ru.bitc.webnet.domain.entity

/**
 *
 */
data class FlowInterviewTopic(
    val id: String,
    val position: String,
    val categoryDifficulty: String,
    val topics: List<String>,
    val maxQuestion: Int,
    val time: String,
)