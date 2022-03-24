package com.weber.scratchpadv2.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun HomeButton(title: String, clickable: () -> Unit = {}) {
    Text(
        text = title,
        style = MaterialTheme.typography.h3,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .clickable {
                clickable.invoke()
            }
            .fillMaxWidth()
            .padding(16.dp)
    )
}