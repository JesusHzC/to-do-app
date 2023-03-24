package com.github.jesushzc.todoapplication.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = DarkPrimaryColor,
    primaryVariant = AccentColor,
    secondary = PrimaryColor,
    background = WhiteColor,
    surface = WhiteColor,
    onPrimary = TextPrimaryColor,
)

@Composable
fun ToDoApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}