package com.applid.gym.ui.screens.profile_screen.common.achievements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AchievementItem(image: Int, title : String, achievementData: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
    ) {
        Image(
            painterResource(image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .weight(1F)
        )
        Text(text = "$title $achievementData", modifier = Modifier.weight(3F))
        IconButton(
            onClick = {},
            modifier = Modifier.weight(1F)
        ){
            Icon(
                Icons.Filled.Edit,
                contentDescription = "Localized description",
                tint = Color.Red
            )
        }
        

    }
}