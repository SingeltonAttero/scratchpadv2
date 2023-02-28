package ru.bitc.webnet.date.local

import android.content.res.Resources
import java.io.BufferedReader

/**
 *
 */
class OpenAssetsFileProvider constructor(private val resources: Resources) {


    fun getFileJson(fileName: String): String {
        return resources.assets.open(fileName).bufferedReader()
            .use(BufferedReader::readText)
    }


}