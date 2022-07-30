package com.applid.gym.ui

import com.applid.gym.ui.screens.home_screen.HomeScreen
import com.applid.gym.ui.screens.leaderboard_screen.LeaderboardScreen
import com.applid.gym.ui.screens.profile_screen.ProfileScreen
import com.applid.gym.ui.screens.qr_scan_screen.QrScanScreen
import com.applid.gym.ui.screens.settings_screen.SettingsScreen

sealed class Router(val route : String) {
    object HomeScreen : Router("home")
    object LeaderboardScreen : Router("leaderboard")
    object SettingsScreen : Router("settings")
    object ProfileScreen : Router("profile")
    object QrScanScreen : Router("qrscan")
    object LoginScreen : Router("login")

}
