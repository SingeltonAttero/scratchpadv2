package ru.bitc.webnet.component.category

/**
 *
 */
data class InterviewCategoryState(
    val id: String,
    val position: String,
    val categoryDifficulty: InterviewType,
    val topic: List<String>,
    val maxQuestion: Int,
    val time: String,
    val fullPositionName: String
)


enum class InterviewType(val humanTitle: String) {
    MIDDLE("Middle"),
    JUNIOR("Junior"),
    SENIOR("Senior"),
    TEAM_LEAD("TeamLead"),
    TRAINEE("Trainee")
}