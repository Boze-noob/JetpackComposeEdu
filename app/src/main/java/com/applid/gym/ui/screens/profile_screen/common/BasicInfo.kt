package com.applid.gym.ui.screens.profile_screen.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.gym.R

@Composable
fun BasicInfo(){
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth(),
        ){
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "28", style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)
                ))
                )
            }
            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "89", style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "Weight",
                    style = TextStyle(
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)
                        ))
                )
            }
            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "30", style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "Days left",
                    style = TextStyle(
                        color = Color.Black.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)
                        ))
                )
            }
        }
    }
}