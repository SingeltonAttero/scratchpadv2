package com.weber.scratchpadv2.screen.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weber.scratchpadv2.ScreenDestinations
import com.weber.scratchpadv2.screen.hint.HintScreen
import com.weber.scratchpadv2.screen.home.HomeScreen
import com.weber.scratchpadv2.screen.prepare.PrepareGameSessionScreen
import com.weber.scratchpadv2.screen.setting.SettingScreen
import com.weber.scratchpadv2.ui.theme.Scratchpadv2Theme

@Composable
fun ApplicationScreen() {
    Scratchpadv2Theme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = ScreenDestinations.HomeScreen.name
        ) {
            composable(ScreenDestinations.HomeScreen.name) {
                ScreenContainer {
                    HomeScreen(navController)
                }
            }
            composable(ScreenDestinations.PrepareGameSessionScreen.name) {
                ScreenContainer {
                    PrepareGameSessionScreen(modifier = Modifier.fillMaxSize())
                }
            }

            composable(ScreenDestinations.SettingScreen.name) {
                ScreenContainer {
                    SettingScreen(modifier = Modifier.fillMaxSize())
                }
            }

            composable(ScreenDestinations.HintScreen.name) {
                ScreenContainer {
                    HintScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}



@Composable
private fun ScreenContainer(screen: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        screen.invoke()
    }
}