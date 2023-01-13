package ru.bitc.webnet.ui.screens.flow.mock

import ru.bitc.webnet.component.category.InterviewCategoryState
import ru.bitc.webnet.component.category.InterviewType


object FlowInterviewTopicUIMock {
    val FlowInterviewTopicList = listOf(
        InterviewCategoryState(
            id = "1",
            position = "Android Developer",
            categoryDifficulty = InterviewType.JUNIOR,
            topic = listOf(
                "Базовые вопросы по kotlin/java core",
                "Базовые вопросы по android core",
                "Вопросы по алгоритмам"
            ),
            maxQuestion = 20,
            time = "2 часа",
            fullPositionName = "Junior Android Developer"
        ),
        InterviewCategoryState(
            id = "2",
            position = "Android Developer",
            categoryDifficulty = InterviewType.TEAM_LEAD,
            topic = listOf(
                "Продвинутые вопросы по kotlin/java core",
                "Продвинутые вопросы по android core",
                "Вопросы по алгоритмам",
                "Базовые понятия архитектуры проекта"
            ),
            maxQuestion = 20,
            time = "2 часа",
            fullPositionName = "Middle Android Developer"
        ),
    )
}