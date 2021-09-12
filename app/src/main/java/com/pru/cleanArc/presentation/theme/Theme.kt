package com.pru.cleanArc.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColorPalette = lightColors(
    primary = ColorPrimary,
    background = Background,
    onBackground = ColorOnBackground,
    onPrimary = Color.White
)

@Composable
fun CryptocurrencyAppYTTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}