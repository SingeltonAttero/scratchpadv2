package ru.bitc.webnet.ui.screens.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.bitc.webnet.Route
import ru.bitc.webnet.component.category.InterviewCategoryComponent

/**
 *
 */
@Composable
fun FlowInterviewScreen(
    mainNavHostController: NavHostController,
    viewModel: FlowInteractionViewModel = hiltViewModel()
) {

    val state = viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(content = {
            state.value.forEachIndexed { index, partState ->
                item {
                    if (index == 0) {
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                    InterviewCategoryComponent(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        state = partState
                    ) {
                        mainNavHostController.navigate(
                            Route.DetailedInterview.openDetailed(
                                partState.id
                            )
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        })
    }
}