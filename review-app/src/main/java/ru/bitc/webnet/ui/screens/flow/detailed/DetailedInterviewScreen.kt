package ru.bitc.webnet.ui.screens.flow.detailed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun DetailedInterviewScreen(
    interviewId: String,
    viewModel: DetailedInterviewViewModel = hiltViewModel(),
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Start interview")
        }
    }

}