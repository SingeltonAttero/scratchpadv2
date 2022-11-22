package ru.bitc.webnet.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.bitc.webnet.ui.theme.ReviewStatisticsTheme

/**
 * Разводящий стартовый экран
 */
@Composable
fun MainAppScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReviewStatisticsTheme {
        Text(text = "Главный экран")
    }
}