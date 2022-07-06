package com.applid.gym.ui.screens.settings_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Notifications(){
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth()
    ){
        Column(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(text = "Notificaitons", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Exercise : 4 pm", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(3F))
                Switch(
                    checked = true,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.DarkGray,
                        uncheckedThumbColor = Color.DarkGray,
                        checkedTrackColor = Color.Blue,
                        uncheckedTrackColor = Color.Blue,
                    ),
                    modifier = Modifier.weight(1F)

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Water : every 1 hour", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(3F))
                Switch(
                    checked = true,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.DarkGray,
                        uncheckedThumbColor = Color.DarkGray,
                        checkedTrackColor = Color.Blue,
                        uncheckedTrackColor = Color.Blue,
                    ),
                    modifier = Modifier.weight(1F)

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Walk : 7 am", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(3F))
                Switch(
                    checked = true,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.DarkGray,
                        uncheckedThumbColor = Color.DarkGray,
                        checkedTrackColor = Color.Blue,
                        uncheckedTrackColor = Color.Blue,
                    ),
                    modifier = Modifier.weight(1F)

                )
            }
        }
    }
}