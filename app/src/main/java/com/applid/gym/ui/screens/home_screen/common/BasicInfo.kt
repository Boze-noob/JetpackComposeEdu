package com.applid.gym.ui.screens.home_screen.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.applid.gym.R

@Preview
@Composable
fun BasicInfo() {

    Row(
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .height(200.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 2.dp,
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp, vertical = 5.dp),

        ) {
            Column(
                modifier = Modifier.padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Image(
                        painterResource(R.drawable.trophy_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(40.dp, 40.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text("Completed", style = MaterialTheme.typography.subtitle1, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text("12", style = MaterialTheme.typography.h1, fontSize = 40.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Attempted workouts", style = MaterialTheme.typography.subtitle1, fontSize = 16.sp)
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = 2.dp,
                backgroundColor = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(vertical = 5.dp),
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row() {
                        Image(
                            painterResource(R.drawable.schedule_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp, 40.dp)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Workouts \nleft", style = MaterialTheme.typography.subtitle1, fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(text = "20", style = MaterialTheme.typography.subtitle1, fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "Workouts")
                    }
                }

            }
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = 2.dp,
                backgroundColor = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(vertical = 5.dp),

            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row() {
                        Image(
                            painterResource(R.drawable.weight_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp, 40.dp)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Current weight", style = MaterialTheme.typography.subtitle1, fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(text = "75", style = MaterialTheme.typography.h1, fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "KG")
                    }
                }
            }
        }
    }


}