package com.weber.scratchpadv2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.R
import com.weber.scratchpadv2.components.core.neoCircleShadow


@Composable
fun NeoSelector(
    modifier: Modifier,
    titleText: String = "",
    count: String = "",
    clickPlus: (String) -> Unit = {},
    clickMinus: (String) -> Unit = {}
) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = titleText, style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SelectorButtons(R.drawable.ic_minus_selector, click = {
                clickMinus.invoke(count)
            })
            Text(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 16.dp, end = 16.dp),
                text = count,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )
            SelectorButtons(drawableRes = R.drawable.ic_plus_selector, click = {
                clickPlus.invoke(count)
            })
        }
    }
}

@Composable
private fun SelectorButtons(
    @DrawableRes drawableRes: Int = R.drawable.ic_spy_main_logo,
    click: () -> Unit = { }
) {
    Button(
        modifier = Modifier
            .size(64.dp)
            .neoCircleShadow(
                shadowBlurRadius = 8.dp,
                offsetY = 4.dp,
                offsetX = 4.dp
            ),
        onClick = { click.invoke() },
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = "counter button",
        )
    }
}