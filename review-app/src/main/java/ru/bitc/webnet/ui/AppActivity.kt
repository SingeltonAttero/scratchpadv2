package ru.bitc.webnet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ru.bitc.webnet.Route
import ru.bitc.webnet.ui.screens.MainAppScreen
import ru.bitc.webnet.ui.screens.flow.detailed.DetailedInterviewScreen
import ru.bitc.webnet.ui.theme.ReviewStatisticsTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewStatisticsTheme {
                val navHostController = rememberNavController()
                NavHost(
                    navController = navHostController,
                    startDestination = Route.MainApp.navigate
                ) {

                    composable(Route.MainApp.navigate) {
                        MainAppScreen(navHostController)
                    }

                    composable(
                        Route.DetailedInterview.navigate,
                        arguments = listOf(navArgument(Route.DetailedInterview.key) {
                            defaultValue = "0"
                        })
                    ) { navBackStackEntry ->
                        DetailedInterviewScreen(
                            interviewId = checkNotNull(navBackStackEntry.arguments?.getString(Route.DetailedInterview.key))
                        )
                    }
                }
            }
        }
    }
}

