package com.applid.gym.ui.screens.settings_screen.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Other(){
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
            Text(text = "Other settings", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Privacy policy", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(5F))
                Text(
                    modifier = Modifier.weight(1F),
                    text = "View",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Terms and conditions", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(5F))
                Text(
                    modifier = Modifier.weight(1F),
                    text = "View",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Rate us", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(5F))
                Text(
                    modifier = Modifier.weight(1F),
                    text = "Rate",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Contact us", style = MaterialTheme.typography.subtitle1, modifier = Modifier.weight(5F))
                Text(
                    modifier = Modifier.weight(1F),
                    text = "Contact",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}