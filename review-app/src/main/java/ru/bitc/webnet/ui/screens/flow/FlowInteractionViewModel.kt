package ru.bitc.webnet.ui.screens.flow

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.bitc.webnet.component.category.InterviewCategoryState
import ru.bitc.webnet.component.category.InterviewType
import ru.bitc.webnet.core.BaseViewModel
import ru.bitc.webnet.domain.FlowInterviewTopicRepository
import ru.bitc.webnet.domain.entity.FlowInterviewTopic
import javax.inject.Inject


@HiltViewModel
class FlowInteractionViewModel @Inject constructor(private val flowInterviewRepository: FlowInterviewTopicRepository) :
    BaseViewModel() {

    private val state = MutableStateFlow(emptyList<InterviewCategoryState>())

    val uiState: StateFlow<List<InterviewCategoryState>>
        get() = state

    init {
        flowInterviewRepository.getInterviewTopic()
            .onEach { flowInterviewTopics ->
                state.value = flowInterviewTopics.map(::convertEntityToState)
            }
            .launchIn(viewModelScope)
    }

    private fun convertEntityToState(entity: FlowInterviewTopic): InterviewCategoryState {
        return InterviewCategoryState(
            id = entity.id,
            position = entity.position,
            categoryDifficulty = convertCategoryDifficultyToType(entity.categoryDifficulty),
            topic = entity.topics,
            maxQuestion = entity.maxQuestion,
            time = entity.time,
            fullPositionName = entity.categoryDifficulty + " " + entity.position
        )
    }

    private fun convertCategoryDifficultyToType(categoryDifficulty: String): InterviewType {
        return when (categoryDifficulty) {
            InterviewType.JUNIOR.humanTitle -> InterviewType.JUNIOR
            InterviewType.TEAM_LEAD.humanTitle -> InterviewType.TEAM_LEAD
            InterviewType.MIDDLE.humanTitle -> InterviewType.MIDDLE
            InterviewType.SENIOR.humanTitle -> InterviewType.SENIOR
            else -> InterviewType.TRAINEE
        }
    }


}