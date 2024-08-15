package com.example.vybs.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import com.example.vybs.core.data.db.userEntity.UserEntityRepository
import com.example.vybs.features.intro.screens.IntroScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(navController: NavHostController, userEntityRepository: UserEntityRepository) {
    val scope = rememberCoroutineScope()

    // Remember the start destination as a state variable
    val startDestination = remember { mutableStateOf<String?>(null) }

    // Perform the user check asynchronously
    LaunchedEffect(Unit) {
        scope.launch {
            val user = userEntityRepository.getUser()
            startDestination.value = if (user != null) {
                NavRoutes.NextScreen.route
            } else {
                NavRoutes.IntroScreen.route
            }
        }
    }

    // Only render the NavHost when the start destination is determined
    startDestination.value?.let { destination ->
        NavHost(navController = navController, startDestination = destination) {
            composable(NavRoutes.IntroScreen.route) {
                IntroScreen(navController = navController)
            }
            composable(NavRoutes.NextScreen.route) {
                Text("This is the next screen")
            }
        }
    }
}


enum class NavRoutes(val route: String) {
    IntroScreen("intro_screen"),
    NextScreen("next_screen_route")
}