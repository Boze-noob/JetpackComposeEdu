package com.applid.gym.ui.screens.home_screen

import HomeAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.R
import com.applid.gym.domain.models.home.DiscoverWorkout
import com.applid.gym.ui.screens.home_screen.components.BasicInfo
import com.applid.gym.ui.screens.home_screen.components.DiscoverWorkouts
import com.applid.gym.ui.screens.home_screen.components.MotivationQuote
import com.applid.gym.ui.view_models.home.BasicInfoEvent
import com.applid.gym.ui.view_models.home.BasicInfoViewModel

@Composable
fun HomeScreen(
    viewModel : BasicInfoViewModel = hiltViewModel()
) {
    viewModel.onEvent(BasicInfoEvent.Init(1))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        HomeAppBar(mainTxt = "MainTxt", descriptionTxt = "DescriptionTxt")
        Spacer(modifier = Modifier.height(20.dp))
        BasicInfo()
        Spacer(modifier = Modifier.height(20.dp))
        DiscoverWorkouts(List(20){
            DiscoverWorkout(
                title = "Title",
                description = "Description",
                backgroundColor = Color.Blue,
                image = R.drawable.trophy_icon
            )
        })
        Spacer(modifier = Modifier.height(20.dp))
        MotivationQuote()
    }
}