package com.weber.scratchpadv2.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
            val interactionSource = remember { MutableInteractionSource() }
            val buttonInteraction = interactionSource.collectIsPressedAsState()
            val coroutineScope = rememberCoroutineScope()
            IconButton(
                modifier = Modifier.combinedClickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(),
                    onLongClick = {
                        coroutineScope.launch {
                            while (!buttonInteraction.value) {
                                delay(1000)
                                counter--
                            }
                        }
                    }) {},
                onClick = {
                 //   counter--
                }
            ) {
                Icon(
                    modifier = Modifier.size(48.dp, 48.dp),
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp),
                text = counter.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )
            IconButton(onClick = {
                counter++
            }) {
                Icon(
                    modifier = Modifier.size(48.dp, 48.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    tint = Color.White
                )
            }

        }
    }
}