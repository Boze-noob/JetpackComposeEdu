package com.applid.gym.ui.screens.profile_screen.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applid.gym.R
import com.applid.gym.ui.helpers.ScreenSize

@Preview
@Composable
fun AppBar(){
    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()
    val screenWidth = ScreenSize(LocalContext.current).getScreenWidth()

    Box(modifier = Modifier.background(
        brush = Brush.linearGradient(
            colors = listOf(Color.Yellow, Color.Red),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    ),){
        IconButton(
            onClick = { } ,
            modifier = Modifier.align(Alignment.TopEnd).padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                tint = Color.Blue,
                contentDescription = ""
            )
        }
        Box(
            modifier = Modifier
                .height((screenHeight / 3.9).dp)
                .width(screenWidth.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.size(70.dp),
                    border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
                    shape = CircleShape,
                    elevation = 2.dp,)
                {
                    Image(
                        painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Autumn Goodman", style = MaterialTheme.typography.h1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "Kes West, Florida", style = MaterialTheme.typography.subtitle1)
            }
        }
    }

}