package ru.bitc.webnet.date.local

import android.content.res.Resources
import java.io.BufferedReader

/**
 *
 */
class OpenAssetsFileProvider constructor(private val resources: Resources) {


    fun getFileJson(): String {
        return resources.assets.open(INTERVIEW_TOPIC_JSON).bufferedReader()
            .use(BufferedReader::readText)
    }


    private companion object {
        const val INTERVIEW_TOPIC_JSON = "InterviewTopic.json"
    }
}