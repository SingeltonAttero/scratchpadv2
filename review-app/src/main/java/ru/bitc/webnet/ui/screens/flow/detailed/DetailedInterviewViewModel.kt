package ru.bitc.webnet.ui.screens.flow.detailed

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.bitc.webnet.core.BaseViewModel
import javax.inject.Inject


@HiltViewModel
class DetailedInterviewViewModel @Inject constructor() : BaseViewModel() {

    private val state = MutableStateFlow("Start")

    val uiState: Flow<String>
        get() = state

    fun startInterview(interviewId: String) {

    }

}