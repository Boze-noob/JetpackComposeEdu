package com.applid.gym.ui.screens.home_screen.common

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.gym.domain.models.DiscoverWorkout
import com.applid.gym.ui.helpers.Sizes


@Composable
fun DiscoverWorkouts(discoverWorkoutList: List<DiscoverWorkout>){

    Column(
        modifier = Modifier.padding(horizontal = 25.dp)
    ) {
        Text(text = "Discover new workouts", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(discoverWorkoutList) { discoverWorkout ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 2.dp,
                    backgroundColor = discoverWorkout.backgroundColor,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .width(cardWidth.dp),
                    ) {
                    Row(
                        Modifier.padding(vertical = 25.dp, horizontal = 15.dp)
                    ) {
                        Column() {
                            Text(text = discoverWorkout.title, style = MaterialTheme.typography.h3)
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(text = discoverWorkout.description, style = MaterialTheme.typography.subtitle1)
                        }
                        Image(
                            painterResource(discoverWorkout.image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp, 40.dp)
                        )
                    }

                }
            }
        }
    }
}