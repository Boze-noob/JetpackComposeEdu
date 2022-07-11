package com.applid.gym.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Loader(color : Color, modifier: Modifier = Modifier.padding(vertical = 10.dp)) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color
    )
}