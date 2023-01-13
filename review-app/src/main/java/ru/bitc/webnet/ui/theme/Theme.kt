package ru.bitc.webnet.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.bitc.webnet.ui.theme.Colors.BackgroundWhite
import ru.bitc.webnet.ui.theme.Colors.Primary
import ru.bitc.webnet.ui.theme.Colors.PrimaryVariant
import ru.bitc.webnet.ui.theme.Colors.SecondaryBing

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    secondary = SecondaryBing,
    background = BackgroundWhite,
    surface = BackgroundWhite,
    onPrimary = BackgroundWhite,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun ReviewStatisticsTheme(
    content: @Composable () -> Unit
) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}