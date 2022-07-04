package com.applid.gym.ui.screens.profile_screen.common.achievements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.domain.models.profile.Achievement


@Composable
fun Achievements(){
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
            .fillMaxHeight()
    ) {
        Text(text = "Achievements", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(12.dp))
    }
}