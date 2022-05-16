package com.applid.gym.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = whiteDarkTheme,
        primaryVariant = lightBlueDarkTheme,
        secondary = darkBlueDarkTheme,
        secondaryVariant = black,
        background = darkGrey,
)

private val LightColorPalette = lightColors(
        primary = whiteLightTheme,
        primaryVariant = darkBlueLightTheme,
        secondary = lightBlueLightTheme,
        secondaryVariant = purple,
        background = whiteLightTheme,

        /* Other default colors to override

    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GymTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}