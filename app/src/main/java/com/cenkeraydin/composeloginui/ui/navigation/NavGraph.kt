package com.cenkeraydin.composeloginui.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.cenkeraydin.composeloginui.ui.navigation.screen.Home
import com.cenkeraydin.composeloginui.ui.navigation.screen.Login
import com.cenkeraydin.composeloginui.ui.navigation.screen.OnBoardingRoute
import com.cenkeraydin.composeloginui.ui.navigation.screen.SignUp
import com.cenkeraydin.composeloginui.ui.screen.home.HomeScreen
import com.cenkeraydin.composeloginui.ui.screen.login.LoginScreen
import com.cenkeraydin.composeloginui.ui.screen.onboarding.OnBoardingScreen
import com.cenkeraydin.composeloginui.ui.screen.registration.SignUpScreen

object screen{
    const val OnBoardingRoute = "OnBoardingScreen"
    const val Login = "LoginScreen"
    const val SignUp = "SignUpScreen"
    const val Home = "HomeScreen"
}
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = OnBoardingRoute
    ) {
        composable(route = OnBoardingRoute) { OnBoardingScreen(navController) }
        composable(route = Login) { LoginScreen(navController) }
        composable(route = SignUp) { SignUpScreen(navController) }
        composable(route = Home) { HomeScreen(navController) }
    }
}


