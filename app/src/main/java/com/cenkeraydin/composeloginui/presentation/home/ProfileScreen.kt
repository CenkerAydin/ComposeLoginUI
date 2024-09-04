package com.cenkeraydin.composeloginui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.composeloginui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
                .background(Color(android.graphics.Color.rgb(236, 236, 236))),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout {
                val (topImg, profile) = createRefs()
                Image(
                    painter = painterResource(id = R.drawable.top_background),
                    contentDescription = "background",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = "account",
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(4.dp, Color.White, CircleShape)
                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
            Text(
                text = "Cenker Aydın",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold  ,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "cenkeraydin14@gmail.com",
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 10.dp, 32.dp, 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.rgb(255, 255, 255)),
                ),
                shape = RoundedCornerShape(15)
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_3),
                        contentDescription = "setting icon",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable { }
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text ="Account Information",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)
                }
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 10.dp, 32.dp, 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.rgb(255, 255, 255)),
                ),
                shape = RoundedCornerShape(15)
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_1),
                        contentDescription = "setting icon",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable { }
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text ="Settings",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)
                }
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 10.dp, 32.dp, 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.rgb(255, 255, 255)),
                ),
                shape = RoundedCornerShape(15)
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_4),
                        contentDescription = "setting icon",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable { }
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text ="Notifications",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)
                }
            }

        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}