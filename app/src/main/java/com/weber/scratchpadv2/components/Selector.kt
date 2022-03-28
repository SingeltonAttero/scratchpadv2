package com.weber.scratchpadv2.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectorCounter(
    modifier: Modifier,
    titleText: String = "Выберите количество игроков",
) {
    var counter by remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = titleText,
            style = MaterialTheme.typography.subtitle1
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .size(48.dp, 48.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = {
                            }, onPress = {
                                counter--
                            })
                    },
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp),
                text = counter.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )
            Icon(
                modifier = Modifier
                    .size(48.dp, 48.dp)
                    .clickable {
                        counter++
                    },
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}