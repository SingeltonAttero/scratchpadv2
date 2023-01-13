package ru.bitc.webnet.component.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.bitc.webnet.R
import ru.bitc.webnet.ui.theme.Colors

/**
 *
 */
@Composable
fun InterviewCategoryComponent(
    modifier: Modifier = Modifier,
    state: InterviewCategoryState
) {
    Card(
        modifier = modifier.fillMaxWidth()
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
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_topic_dots),
                            modifier = Modifier.size(12.dp),
                            contentDescription = text,
                            tint = Colors.Primary
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(text = text)
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
                    text = "${stringResource(R.string.duration_interview)} ${state.time}",
                    fontSize = 12.sp,
                    color = Color.Blue,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
        })
    }
}