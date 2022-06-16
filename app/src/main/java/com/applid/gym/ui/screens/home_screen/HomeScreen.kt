package com.applid.gym.ui.screens.home_screen

import HomeAppBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        HomeAppBar(mainTxt = "MainTxt", descriptionTxt = "DescriptionTxt")
    }
}