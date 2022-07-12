package com.applid.gym.ui.screens.home_screen.components

import com.applid.gym.R
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.applid.gym.common.Constants
import com.applid.gym.domain.models.home.DiscoverWorkout
import com.applid.gym.ui.common.Loader
import com.applid.gym.ui.helpers.ScreenSize
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsViewModel


@Composable
fun DiscoverWorkouts(
    viewModel: DiscoverWorkoutsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(text = "Discover new workouts", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(10.dp))
        List(
            discoverWorkoutList = state.discoverWorkouts ?: emptyList(),
            isLoading = state.isLoading
        )
    }
}

@Composable
fun List(discoverWorkoutList: List<DiscoverWorkout>, isLoading: Boolean) {
    val screenWidth: Float = ScreenSize(LocalContext.current).getScreenWidth()

    if (discoverWorkoutList.isEmpty()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No workouts to display",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    } else if (isLoading) {
        Loader(color = Color.Green)
    } else {
        LazyRow {
            items(discoverWorkoutList) { discoverWorkout ->
                Card(
                    shape = RoundedCornerShape(30.dp),
                    elevation = 2.dp,
                    backgroundColor = Color(discoverWorkout.backgroundColor.toColorInt()),
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 5.dp)
                        .width((screenWidth / 1.4).dp),
                ) {
                    Row(
                        Modifier.padding(vertical = 25.dp, horizontal = 15.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1F)
                        ) {
                            Text(
                                text = discoverWorkout.title,
                                style = MaterialTheme.typography.h3
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = discoverWorkout.numOfExercises,
                                style = MaterialTheme.typography.subtitle1
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = discoverWorkout.time,
                                style = MaterialTheme.typography.subtitle1
                            )
                        }
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(Constants.IMAGE_BASE_URL + discoverWorkout.image)
                                .crossfade(true)
                                .build(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            onError = {
                                Log.d("DiscoverWorkout", "Image loading error ${it.result.throwable}")
                            },
                            modifier = Modifier
                                .size((screenWidth / 1.8).dp, 100.dp)
                                .weight(1F),
                        )
                    }
                }
            }
        }
    }
}
