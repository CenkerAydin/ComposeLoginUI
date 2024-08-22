package com.cenkeraydin.composeloginui.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.cenkeraydin.composeloginui.ui.navigation.Screen.SPLASHSCREEN
import com.cenkeraydin.composeloginui.ui.navigation.Screen.HOME
import com.cenkeraydin.composeloginui.ui.navigation.Screen.LOGIN
import com.cenkeraydin.composeloginui.ui.navigation.Screen.ONBOARDING
import com.cenkeraydin.composeloginui.ui.navigation.Screen.NOTES
import com.cenkeraydin.composeloginui.ui.navigation.Screen.PROFILE
import com.cenkeraydin.composeloginui.ui.navigation.Screen.SIGNUP
import com.cenkeraydin.composeloginui.ui.screen.home.HomeScreen
import com.cenkeraydin.composeloginui.ui.screen.home.NotesScreen
import com.cenkeraydin.composeloginui.ui.screen.home.ProfileScreen
import com.cenkeraydin.composeloginui.ui.screen.login.LoginScreen
import com.cenkeraydin.composeloginui.ui.screen.onboarding.OnBoardingScreen
import com.cenkeraydin.composeloginui.ui.screen.registration.SignUpScreen
import com.cenkeraydin.composeloginui.ui.screen.splash.SplashScreen

object Screen{
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
        startDestination = SPLASHSCREEN,

    ) {
        composable(
            route = ONBOARDING,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000))
            },
        ) { OnBoardingScreen(navController) }
        composable(
            route = LOGIN,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(3000))
            },
        ) { LoginScreen(navController) }
        composable(
            route = SIGNUP,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000))
            },
            ) { SignUpScreen(navController) }
        composable(
            route = HOME,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000))
            },
            ) { HomeScreen(navController) }
        composable(route = SPLASHSCREEN) { SplashScreen(navController) }
        composable(
            route = NOTES,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000))
            }
        ) { NotesScreen(navController) }
        composable(
            PROFILE,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000)
                ) + fadeIn(animationSpec = tween(1000))
            }
        ) { ProfileScreen(navController) }
    }
}


