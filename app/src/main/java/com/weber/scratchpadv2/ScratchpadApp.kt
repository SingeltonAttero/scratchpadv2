package com.weber.scratchpadv2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScratchpadApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}