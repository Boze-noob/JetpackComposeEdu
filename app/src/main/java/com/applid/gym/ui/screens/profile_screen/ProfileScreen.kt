package com.applid.gym.ui.screens.profile_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.screens.profile_screen.common.AppBar
import com.applid.gym.ui.screens.profile_screen.common.BasicInfo

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        AppBar()
        Spacer(modifier = Modifier.height(15.dp))
        BasicInfo()
    }
}