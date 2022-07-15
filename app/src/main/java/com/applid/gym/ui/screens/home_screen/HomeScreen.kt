package com.applid.gym.ui.screens.home_screen

import HomeAppBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.ui.screens.home_screen.components.BasicInfo
import com.applid.gym.ui.screens.home_screen.components.DiscoverWorkouts
import com.applid.gym.ui.screens.home_screen.components.MotivationQuote
import com.applid.gym.ui.view_models.home.appBar.AppBarEvent
import com.applid.gym.ui.view_models.home.appBar.AppBarViewModel
import com.applid.gym.ui.view_models.home.basicInfo.BasicInfoEvent
import com.applid.gym.ui.view_models.home.basicInfo.BasicInfoViewModel
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsEvent
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsViewModel
import com.applid.gym.ui.view_models.home.userProgressPercentage.UserProgressPercentageEvent
import com.applid.gym.ui.view_models.home.userProgressPercentage.UserProgressPercentageViewModel

@Composable
fun HomeScreen(
    basicInfoViewModel : BasicInfoViewModel = hiltViewModel(),
    discoverWorkoutsViewModel : DiscoverWorkoutsViewModel = hiltViewModel(),
    appBarViewModel: AppBarViewModel = hiltViewModel(),
    userProgressPercentageViewModel: UserProgressPercentageViewModel = hiltViewModel(),
) {
    basicInfoViewModel.onEvent(BasicInfoEvent.Init(1))
    discoverWorkoutsViewModel.onEvent(DiscoverWorkoutsEvent.Init)
    appBarViewModel.onEvent(AppBarEvent.Init(1))
    userProgressPercentageViewModel.onEvent(UserProgressPercentageEvent.Init(exerciseID = 2))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        HomeAppBar(mainTxt = "MainTxt", descriptionTxt = "DescriptionTxt")
        Spacer(modifier = Modifier.height(20.dp))
        BasicInfo()
        Spacer(modifier = Modifier.height(20.dp))
        DiscoverWorkouts()
        Spacer(modifier = Modifier.height(20.dp))
        MotivationQuote()
    }
}