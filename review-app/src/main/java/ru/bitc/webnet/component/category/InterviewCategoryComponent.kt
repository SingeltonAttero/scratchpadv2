@file:OptIn(ExperimentalMaterialApi::class)

package ru.bitc.webnet.component.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.bitc.webnet.R
import ru.bitc.webnet.ui.theme.Colors


@Composable
fun InterviewCategoryComponent(
    modifier: Modifier = Modifier,
    state: InterviewCategoryState,
    clickableComponent: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            clickableComponent.invoke()
        }
    ) {
        Column(content = {
            Text(
                text = state.fullPositionName,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )
            state.topic.forEach { text ->
                Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_topic_dots),
                            modifier = Modifier.size(12.dp),
                            contentDescription = text,
                            tint = Colors.Primary
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = text,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 16.dp)
                    .padding(bottom = 12.dp)
            ) {
                Text(
                    text = state.categoryDifficulty.humanTitle,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = state.time,
                    fontSize = 12.sp,
                    color = Color.Blue,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
        })
    }
}