package com.cenkeraydin.composeloginui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.cenkeraydin.composeloginui.ui.navigation.screen.SPLASHSCREEN
import com.cenkeraydin.composeloginui.ui.navigation.screen.HOME
import com.cenkeraydin.composeloginui.ui.navigation.screen.LOGIN
import com.cenkeraydin.composeloginui.ui.navigation.screen.ONBOARDING
import com.cenkeraydin.composeloginui.ui.navigation.screen.NOTES
import com.cenkeraydin.composeloginui.ui.navigation.screen.PROFILE
import com.cenkeraydin.composeloginui.ui.navigation.screen.SIGNUP
import com.cenkeraydin.composeloginui.ui.screen.home.HomeScreen
import com.cenkeraydin.composeloginui.ui.screen.home.NotesScreen
import com.cenkeraydin.composeloginui.ui.screen.home.ProfileScreen
import com.cenkeraydin.composeloginui.ui.screen.login.LoginScreen
import com.cenkeraydin.composeloginui.ui.screen.onboarding.OnBoardingScreen
import com.cenkeraydin.composeloginui.ui.screen.registration.SignUpScreen
import com.cenkeraydin.composeloginui.ui.screen.splash.SplashScreen

object screen{
    const val SPLASHSCREEN = "SplashScreen"
    const val ONBOARDING = "OnBoardingScreen"
    const val LOGIN = "LoginScreen"
    const val SIGNUP = "SignUpScreen"
    const val HOME = "Home"
    const val NOTES= "Add"
    const val PROFILE ="Profile"
}
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SPLASHSCREEN
    ) {
        composable(route = ONBOARDING) { OnBoardingScreen(navController) }
        composable(route = LOGIN) { LoginScreen(navController) }
        composable(route = SIGNUP) { SignUpScreen(navController) }
        composable(route = HOME) { HomeScreen(navController) }
        composable(route = SPLASHSCREEN) { SplashScreen(navController) }
        composable(route = NOTES) { NotesScreen(navController) }
        composable(PROFILE) { ProfileScreen(navController) }
    }
}


