package com.weber.scratchpadv2

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.weber.scratchpadv2.screen.HomeScreen
import com.weber.scratchpadv2.ui.theme.DarkBackground
import com.weber.scratchpadv2.ui.theme.Scratchpadv2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        fullScreenMode()
        super.onCreate(savedInstanceState)
        setContent {
            Scratchpadv2Theme {
                Surface(color = DarkBackground) {
                    HomeScreen()
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

