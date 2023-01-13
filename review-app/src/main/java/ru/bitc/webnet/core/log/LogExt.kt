package ru.bitc.webnet.core.log

import timber.log.Timber


fun <T> T.applyLogs(message: String = "LOG"): T {
    return this.apply {
        Timber.d(message + this.toString())
    }
}