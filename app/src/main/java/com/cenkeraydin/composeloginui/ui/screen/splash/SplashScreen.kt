package com.cenkeraydin.composeloginui.ui.screen.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.composeloginui.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate("OnBoardingScreen")
    }
    Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.img_splash),
            contentDescription = "Logo"
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome TaskMaster",
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Blue)
                )
            ),
            color = Color.White
        )
    }
}
@Composable
@Preview
fun SplashScreenPreview(){
    val navController = rememberNavController()
    SplashScreen(navController)
}