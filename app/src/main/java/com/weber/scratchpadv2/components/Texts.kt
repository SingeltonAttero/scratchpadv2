package com.weber.scratchpadv2.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.weber.scratchpadv2.R


@Composable
fun TitleStartApp(modifier: Modifier, title: String = stringResource(id = R.string.app_name)) {
    val colorSchemes = listOf(
        Color(0xFFF48FB1),
        Color(0xFFFF8F00),
        Color(0xFFFFC400),
        Color(0xFFB39DDB),
        Color(0xFF00BFA5),
    )
    Row(modifier = modifier) {
        title.forEachIndexed() { index, char ->
            Text(
                text = char.toString(),
                style = MaterialTheme.typography.h1,
                color = colorSchemes[index]
            )
        }
    }
}