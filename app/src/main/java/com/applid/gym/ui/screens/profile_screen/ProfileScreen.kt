package com.applid.gym.ui.screens.profile_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.R
import com.applid.gym.domain.models.profile.Achievement
import com.applid.gym.ui.screens.profile_screen.components.AppBar
import com.applid.gym.ui.screens.profile_screen.components.BasicInfo
import com.applid.gym.ui.screens.profile_screen.components.WeightGraph
import com.applid.gym.ui.screens.profile_screen.components.achievements.AchievementItem
import com.applid.gym.ui.screens.profile_screen.components.achievements.Achievements

@Composable
fun ProfileScreen() {

    val achievements = List(3){Achievement(image = R.drawable.ic_launcher_foreground, title = "title", achievementData = 20)}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //Better practice to use more item elements and put composable inside each of them
        //Spacer and divider can be inside item with other composable, no need to put it in
        //separate item
        item {
            AppBar()
            Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            BasicInfo()
            Spacer(modifier = Modifier.height(15.dp))
        }
        item {
            Achievements()
        }
        //Tried to put this inside Achievements() in another LazyColumn
        //but composable does not allow that cuz vertical scrollable cant be inside another
        //vertical scrollable
        items(achievements) { item ->
            AchievementItem(image = item.image, title = item.title , achievementData = item.achievementData )
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
            WeightGraph()
            //Bottom navigation bar height is fixed to 56dp
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}