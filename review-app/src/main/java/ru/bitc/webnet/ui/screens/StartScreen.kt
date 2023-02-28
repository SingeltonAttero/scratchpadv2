package ru.bitc.webnet.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.bitc.webnet.R
import ru.bitc.webnet.Route
import ru.bitc.webnet.ui.screens.flow.FlowInterviewScreen
import ru.bitc.webnet.ui.screens.flow.detailed.DetailedInterviewScreen
import ru.bitc.webnet.ui.screens.report.ReportTopicScreen
import ru.bitc.webnet.ui.theme.ReviewStatisticsTheme

/**
 * Разводящий стартовый экран
 */
@Composable
fun MainAppScreen(mainNavHostController: NavHostController) {
    val screensList = listOf(
        Route.BottomMenu.FlowInterview,
        Route.BottomMenu.Report
    )
    val innerNavHostController = rememberNavController()
    Scaffold(
        content = {
            Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
                NavGraphStartScreen(innerNavHostController, mainNavHostController)
            }

        },
        bottomBar = {
            StartBottomBar(innerNavHostController, screensList)
        }
    )
}

@Composable
private fun StartBottomBar(
    navController: NavController,
    screensList: List<Route.BottomMenu>
) {
    BottomNavigation {
        val state by navController.currentBackStackEntryAsState()
        screensList.forEach {

            val selectedItem = it.navigate === state?.destination?.route
            when (it) {
                Route.BottomMenu.FlowInterview -> {
                    BottomItemComponent(
                        selected = selectedItem,
                        text = stringResource(R.string.flow_topic_bottom_item_title),
                        icon = Icons.Rounded.Home,
                        itemClick = {
                            navController.navigate(Route.BottomMenu.FlowInterview.navigate)
                        }
                    )
                }
                Route.BottomMenu.Report -> {
                    BottomItemComponent(
                        selected = selectedItem,
                        text = stringResource(R.string.report_topic_bottom_item_title),
                        icon = Icons.Rounded.AccountBox,
                        itemClick = {
                            navController.navigate(Route.BottomMenu.Report.navigate)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavGraphStartScreen(innerNavController: NavHostController, mainController: NavHostController) {
    NavHost(
        navController = innerNavController,
        startDestination = Route.BottomMenu.FlowInterview.navigate
    ) {
        composable(Route.BottomMenu.FlowInterview.navigate) {
            FlowInterviewScreen(mainController)
        }
        composable(Route.BottomMenu.Report.navigate) {
            ReportTopicScreen()
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

@Composable
private fun RowScope.BottomItemComponent(
    selected: Boolean,
    text: String,
    icon: ImageVector,
    itemClick: () -> Unit = {}
) {
    BottomNavigationItem(selected = selected, onClick = { itemClick.invoke() }, icon = {
        Icon(imageVector = icon, contentDescription = text)
    }, label = {
        Text(text = text)
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReviewStatisticsTheme {
        Text(text = "Главный экран")
    }
}