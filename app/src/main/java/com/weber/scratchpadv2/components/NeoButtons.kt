package com.weber.scratchpadv2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.weber.scratchpadv2.components.core.neoRectangleBottomShadow

@Composable
fun StartGameButton(title: String, clickable: () -> Unit = {}) {
    Surface(
        modifier = Modifier
            .padding(32.dp)
            .neoRectangleBottomShadow()
        ,
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier
                    .clickable {
                        clickable.invoke()
                    }
                    .fillMaxWidth()
                    .padding(32.dp),
                text = title,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,

                )
        }
    }
}

@Composable
fun BoxActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    clickable: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .neoRectangleBottomShadow(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    clickable.invoke()
                }
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(id = drawableRes),
                contentDescription = "icon button"
            )
        }
    }
}