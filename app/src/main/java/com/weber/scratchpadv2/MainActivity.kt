package com.weber.scratchpadv2

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weber.scratchpadv2.screen.HomeScreen
import com.weber.scratchpadv2.screen.PrepareGameSessionScreen
import com.weber.scratchpadv2.ui.theme.DarkBackgroundHomeScreen
import com.weber.scratchpadv2.ui.theme.DarkBackgroundPrepareGame
import com.weber.scratchpadv2.ui.theme.Scratchpadv2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        fullScreenMode()
        super.onCreate(savedInstanceState)
        setContent {
            Scratchpadv2Theme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenDestinations.HomeScreen.name
                ) {
                    composable(ScreenDestinations.HomeScreen.name) {
                        Surface(color = DarkBackgroundHomeScreen) {
                            HomeScreen(navController)
                        }
                    }
                    composable(ScreenDestinations.PrepareGameSessionScreen.name) {
                        Surface(color = DarkBackgroundPrepareGame) {
                            PrepareGameSessionScreen(modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }
        }
    }

    private fun fullScreenMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}

