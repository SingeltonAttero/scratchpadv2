package ru.bitc.webnet.date.remote.mock

import ru.bitc.webnet.domain.entity.FlowInterviewTopic
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailed
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailedList
import ru.bitc.webnet.domain.entity.detailed.Questions

object FlowInterviewTopicMock {

    val listInterviewTopic = listOf(
        FlowInterviewTopic(
            id = "1",
            position = "Android Developer",
            categoryDifficulty = "Junior",
            topics = listOf(
                "Базовые вопросы по kotlin/java core",
                "Базовые вопросы по android core",
                "Вопросы по алгоритмам"
            ),
            maxQuestion = 20,
            time = "2 часа"
        ), FlowInterviewTopic(
            id = "2",
            position = "Android Developer",
            categoryDifficulty = "Middle",
            topics = listOf(
                "Продвинутые вопросы по kotlin/java core",
                "Продвинутые вопросы по android core",
                "Вопросы по алгоритмам",
                "Базовые понятия архитектуры проекта"
            ),
            maxQuestion = 20,
            time = "2 часа"
        )
    )

    const val LIST_INTERVIEW_TOPIC_JSON_STRING = """{
  "interviewTopic": [
    {
      "id": "1",
      "position": "Android Developer",
      "categoryDifficulty": "Junior",
      "topicList": [
        "Базовые вопросы по kotlin/java core",
        "Базовые вопросы по android core",
        "Вопросы по алгоритмам"
      ],
      "maxQuestion": 20,
      "time": "2 часа"
    },
    {
      "id": "2",
      "position": "Android Developer",
      "categoryDifficulty": "Middle",
      "topicList": [
        "Продвинутые вопросы по kotlin/java core",
        "Продвинутые вопросы по android core",
        "Вопросы по алгоритмам",
        "Базовые понятия архитектуры проекта"
      ],
      "maxQuestion": 20,
      "time": "2 часа"
    }
  ]
}"""
}