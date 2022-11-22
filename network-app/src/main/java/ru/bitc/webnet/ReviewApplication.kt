package ru.bitc.webnet

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}