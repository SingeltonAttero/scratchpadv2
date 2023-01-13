package ru.bitc.webnet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.bitc.webnet.ui.screens.MainAppScreen
import ru.bitc.webnet.ui.theme.ReviewStatisticsTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewStatisticsTheme {
                MainAppScreen()
            }
        }
    }
}

