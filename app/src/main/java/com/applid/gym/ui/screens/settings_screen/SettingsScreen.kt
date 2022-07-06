package com.applid.gym.ui.screens.settings_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.screens.settings_screen.components.AppSettings
import com.applid.gym.ui.screens.settings_screen.components.AppVersion
import com.applid.gym.ui.screens.settings_screen.components.Notifications
import com.applid.gym.ui.screens.settings_screen.components.Other


@Composable
fun SettingsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item {
            Text(text = "Settings", style = MaterialTheme.typography.h1, modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 30.dp))
            Spacer(modifier = Modifier.height(25.dp))
        }
        item {
            Notifications()
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            AppSettings()
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            Other()
            //Navigation bar have fix size of 56.dp
            Spacer(modifier = Modifier.height(20.dp))
        }
        item { 
            AppVersion()
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}