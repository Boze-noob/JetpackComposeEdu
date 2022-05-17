package com.applid.gym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.applid.gym.ui.common.BottomNavItem
import com.applid.gym.ui.screens.home_screen.HomeScreen
import com.applid.gym.ui.screens.leaderboard_screen.LeaderboardScreen
import com.applid.gym.ui.screens.profile_screen.ProfileScreen
import com.applid.gym.ui.screens.qr_scan_screen.QrScanScreen
import com.applid.gym.ui.screens.settings_screen.SettingsScreen
import com.applid.gym.ui.theme.GymTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymTheme() {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = listOf(
                                    BottomNavItem(
                                        name = "QR scan",
                                        route = "qrscan",
                                        icon = R.drawable.bottom_nav_qr_icon,
                                    ),
                                    BottomNavItem(
                                        name = "Leaderboard",
                                        route = "leaderboard",
                                        icon = R.drawable.bottom_nav_leaderboard_icon
                                    ),
                                    BottomNavItem(
                                        name = "Home",
                                        route = "home",
                                        icon = R.drawable.bottom_nav_home_icon
                                    ),
                                    BottomNavItem(
                                        name = "Profile",
                                        route = "profile",
                                        icon = R.drawable.bottom_nav_profile_icon,
                                    ),
                                    BottomNavItem(
                                        name = "Settings",
                                        route = "settings",
                                        icon = R.drawable.bottom_nav_settings_icon,
                                    ),
                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) {
                        Navigation(navController = navController)
                    }
            }
            }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("leaderboard") {
            LeaderboardScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
        composable("qrscan") {
            QrScanScreen(navController)
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = MaterialTheme.colors.background,
                unselectedContentColor = Color.DarkGray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.name // decorative element
                        )
                        if(selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}