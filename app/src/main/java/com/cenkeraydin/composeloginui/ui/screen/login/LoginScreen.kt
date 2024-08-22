package com.cenkeraydin.composeloginui.ui.screen.login


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.composeloginui.R
import com.cenkeraydin.composeloginui.ui.component.AnnotatedPasswordText
import com.cenkeraydin.composeloginui.ui.component.AnnotatedTextLogin
import com.cenkeraydin.composeloginui.ui.component.AuthText
import com.cenkeraydin.composeloginui.ui.component.DividerLogin

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val loginViewModel: LoginViewModel = viewModel()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val context = LocalContext.current

    val loginResult by loginViewModel.loginResult.observeAsState()
    LaunchedEffect(loginResult) {
        loginResult?.let {
            if (it.isSuccess) {
                navController.navigate("HomeScreen")
            } else {
                Toast.makeText(context, it.exceptionOrNull()?.message ?: "Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .imePadding()
            .paint(
                painterResource(id = R.drawable.background_page),
                contentScale = ContentScale.FillWidth
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            val (topText, culm) = createRefs()
            Text(
                text = "Login to your account",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 48.dp, start = 32.dp)
                    .fillMaxWidth()
                    .constrainAs(topText) {
                        linkTo(parent.top, culm.top, bias = 0.9f)
                        linkTo(parent.start, parent.end, bias = 0f)
                    },
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .constrainAs(culm) {
                        bottom.linkTo(parent.bottom)
                    }
                    .background(
                        color = Color(0x99FFFFFF),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .padding(32.dp)) {
                AuthText(text = "Email")
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("example@gmail.com") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(Color.White, CircleShape)
                )
                AuthText(text = "Password")
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Your Password") },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val iconImage = if (passwordVisible) {
                            painterResource(R.drawable.outline_lock_open_24)
                        } else {
                            painterResource(id = R.drawable.outline_lock_24)
                        }
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(painter = iconImage, contentDescription = "Password Visibility")
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(Color.White, CircleShape)
                )
                AnnotatedPasswordText(navController =navController)
                DividerLogin()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {

                    Button(
                        onClick = {  },
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                            .weight(0.5f)
                            .height(55.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.2f),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.google),
                                contentDescription = "google",
                                modifier = Modifier
                                    .width(25.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .weight(0.7f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Google",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#2f4f86"))
                            )

                        }

                    }
                    Button(
                        onClick = {  },
                        Modifier
                            .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                            .weight(0.5f)
                            .height(55.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.3f),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.facebook),
                                contentDescription = "Facebook",
                                modifier = Modifier
                                    .width(25.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .weight(0.8f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Facebook",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#2f4f86"))
                            )

                        }

                    }
                }
                Button(
                    onClick = { loginViewModel.loginUser(email, password)
                              navController.navigate("Home")},
                    Modifier
                        .padding(top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4758B3),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Login", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                }
                AnnotatedTextLogin(navController)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}