package ru.bitc.webnet.date.remote.mock

import ru.bitc.webnet.domain.entity.detailed.InterviewDetailed
import ru.bitc.webnet.domain.entity.detailed.InterviewDetailedList
import ru.bitc.webnet.domain.entity.detailed.Questions

/**
 *
 */
object InterviewDetailedMock {

    val interviewDetailedList = listOf(
        InterviewDetailedList(
            position = 1,
            interviewDetailed = listOf(
                InterviewDetailed(
                    interviewDetailed = listOf(
                        Questions(
                            answers = listOf("нет, да"), quest = "Можно ли общаться на ты с вами"
                        ),
                        Questions(
                            answers = listOf(
                                "Имел опыт работу в крупной компании",
                                "Работал в мелкой компании",
                                "Работал в аутсорс/аутстаф компании, Другое"
                            ),
                            quest = "Какой опыт работы у вас имеется"
                        ),
                        Questions(
                            answers = listOf("Финтех, Медицина", "Ретейл, BtoB, BtoC, DtoD"),
                            quest = "В какой области у вас наибольший опыт"
                        ),
                        Questions(
                            answers = emptyList(),
                            quest = "Какие обязанности вы выполняли в команде"
                        ),
                        Questions(
                            answers = emptyList(),
                            quest = "Понимает ли как работать в большой команде от 10 андроид разработчиков"
                        ),
                        Questions(
                            answers = emptyList(),
                            quest = "Спросить про scrum/kanban методологии",
                        )
                    ), subtopic = "Знакомство"
                )
            )
        )
    )

    const val INTERVIEW_DETAILED_JSON = """
        {
  "1": [
    {
      "subtopic": "Знакомство",
      "questions": [
        {
          "quest": "Можно ли общаться на ты с вами",
          "answers": [
            "нет",
            "да"
          ]
        },
        {
          "quest": "Какой опыт работы у вас имеется",
          "answers": [
            "Имел опыт работу в крупной компании",
            "Работал в мелкой компании",
            "Работал в аутсорс/аутстаф компании",
            "Другое"
          ]
        },
        {
          "quest": "В какой области у вас наибольший опыт",
          "answers": [
            "Финтех",
            "Медицина",
            "Ретейл",
            "BtoB",
            "BtoC",
            "DtoD"
          ]
        },
        {
          "quest": "Какие обязанности вы выполняли в команде",
          "answers": []
        },
        {
          "quest": "Понимает ли как работать в большой команде от 10 андроид разработчиков",
          "answers": []
        },
        {
          "quest": "Спросить про scrum/kanban методологии",
          "answers": []
        }
      ]
    }
  ],
  "2": [
  ],
  "3": [
  ],
  "4": [
  ],
  "5": [
  ]
}
"""
}