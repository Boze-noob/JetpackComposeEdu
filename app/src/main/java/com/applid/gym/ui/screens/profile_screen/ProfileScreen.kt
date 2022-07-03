package com.applid.gym.ui.screens.profile_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.R
import com.applid.gym.domain.models.profile.Achievement
import com.applid.gym.ui.screens.profile_screen.common.AppBar
import com.applid.gym.ui.screens.profile_screen.common.BasicInfo
import com.applid.gym.ui.screens.profile_screen.common.WeightGraph
import com.applid.gym.ui.screens.profile_screen.common.achievements.Achievements

@Composable
fun ProfileScreen() {

    val achievements = List(3){Achievement(image = R.drawable.ic_launcher_foreground, title = "title", achievementData = 20)}

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppBar()
        Spacer(modifier = Modifier.height(15.dp))
        BasicInfo()
        Spacer(modifier = Modifier.height(15.dp))
        Achievements(achievement = achievements)
        Spacer(modifier = Modifier.height(15.dp))
        WeightGraph()
    }
}