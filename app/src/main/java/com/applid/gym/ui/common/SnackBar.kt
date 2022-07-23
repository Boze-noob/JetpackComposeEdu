package com.applid.gym.ui.common

import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GetSnackBar(data : SnackbarData) {
    return Snackbar(
        snackbarData = data,
        backgroundColor = Color.White
    )
}

