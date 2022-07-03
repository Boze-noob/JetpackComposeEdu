package com.applid.gym.ui.screens.profile_screen.common.achievements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.domain.models.profile.Achievement


@Composable
fun Achievements(achievement: List<Achievement>){
    Column(
        modifier = Modifier.
        padding(horizontal = 10.dp)
    ) {
        Text(text = "Achievements", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn {
            items(achievement) { item ->
                AchievementItem(image = item.image, title = item.title , achievementData = item.achievementData )
            }
        }
    }
}