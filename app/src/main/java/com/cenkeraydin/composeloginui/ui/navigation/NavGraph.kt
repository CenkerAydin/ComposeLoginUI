package com.cenkeraydin.composeloginui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.cenkeraydin.composeloginui.ui.navigation.screen.home
import com.cenkeraydin.composeloginui.ui.navigation.screen.login
import com.cenkeraydin.composeloginui.ui.navigation.screen.onBoardingRoute
import com.cenkeraydin.composeloginui.ui.navigation.screen.signUp
import com.cenkeraydin.composeloginui.ui.navigation.screen.splashScreen
import com.cenkeraydin.composeloginui.ui.screen.home.HomeScreen
import com.cenkeraydin.composeloginui.ui.screen.login.LoginScreen
import com.cenkeraydin.composeloginui.ui.screen.onboarding.OnBoardingScreen
import com.cenkeraydin.composeloginui.ui.screen.registration.SignUpScreen
import com.cenkeraydin.composeloginui.ui.screen.splash.SplashScreen

object screen{
    const val splashScreen = "SplashScreen"
    const val onBoardingRoute = "OnBoardingScreen"
    const val login = "LoginScreen"
    const val signUp = "SignUpScreen"
    const val home = "HomeScreen"
}
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = splashScreen
    ) {
        composable(route = onBoardingRoute) { OnBoardingScreen(navController) }
        composable(route = login) { LoginScreen(navController) }
        composable(route = signUp) { SignUpScreen(navController) }
        composable(route = home) { HomeScreen(navController) }
        composable(route = splashScreen) { SplashScreen(navController) }
    }
}


