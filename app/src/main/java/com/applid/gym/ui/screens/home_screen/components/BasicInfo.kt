package com.applid.gym.ui.screens.home_screen.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.R
import com.applid.gym.ui.common.AutoSizeText
import com.applid.gym.ui.view_models.home.basicInfo.BasicInfoViewModel


@Composable
fun BasicInfo(
    viewModel : BasicInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val basicInfoNullFlag = state.basicInfo == null

    Box(modifier = Modifier.fillMaxSize()) {
        if(state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        } else {
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
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
                        Text(
                            if(!basicInfoNullFlag) state.basicInfo?.completedWorkouts.toString() else " ",
                            style = MaterialTheme.typography.h1,
                            fontSize = 40.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        AutoSizeText(text = "Attempted workouts", textStyle = TextStyle(
                            fontFamily = FontFamily(Font(R.font.open_sans)),
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,)
                        )
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
                                Text(text = if(!basicInfoNullFlag) state.basicInfo?.daysLeft.toString() else " ", style = MaterialTheme.typography.subtitle1, fontSize = 20.sp)
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
                                Text(text = if(!basicInfoNullFlag) state.basicInfo?.weight.toString() else " ", style = MaterialTheme.typography.h1, fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(text = "KG")
                            }
                        }
                    }
                }
            }
        }
        if(state.error.isNotBlank()) {
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG).show()
        }
    }
}