package com.cenkeraydin.composeloginui.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.composeloginui.R
import com.cenkeraydin.composeloginui.ui.component.ButtonOnboarding
import com.cenkeraydin.composeloginui.ui.component.CustomTextDescription
import com.cenkeraydin.composeloginui.ui.component.CustomTextTitle
import com.cenkeraydin.composeloginui.ui.theme.PrimaryPink

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    val itemsTitle = listOf(
        "Kolay Kullanım",
        "Kategorilere Ayırma",
        "Anında Bildirim"
    )
    val itemsDescription = listOf(
        stringResource(R.string.items1),
        stringResource(R.string.items2),
        stringResource(R.string.items3)
    )
    val pagerState = rememberPagerState(0, 0F) {
        3
    }

    var resource = remember { 0 }


    Box(modifier = Modifier.fillMaxHeight()) {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray), contentAlignment = Alignment.Center
            )
            {
                Column {
                    when (page) {
                        0 -> {
                            CustomTextTitle(text = itemsTitle[0])
                            Spacer(modifier = Modifier.height(32.dp))
                            CustomTextDescription(text = itemsDescription[0])
                            Spacer(modifier = Modifier.height(32.dp))
                            resource = R.drawable.img_onboarding
                        }

                        1 -> {
                            CustomTextTitle(text = itemsTitle[1])
                            Spacer(modifier = Modifier.height(32.dp))
                            CustomTextDescription(text = itemsDescription[1])
                            Spacer(modifier = Modifier.height(32.dp))
                            resource = R.drawable.img_onboarding_2
                        }

                        2 -> {
                            CustomTextTitle(text = itemsTitle[2])
                            Spacer(modifier = Modifier.height(32.dp))
                            CustomTextDescription(text = itemsDescription[2])
                            Spacer(modifier = Modifier.height(8.dp))
                            resource = R.drawable.img_onboarding_3

                        }
                    }
                    Image(
                        painter = painterResource(id = resource),
                        contentDescription = "Onboarding",
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .height(400.dp)
                            , contentScale = ContentScale.Crop,
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (pagerState.currentPage == 2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ButtonOnboarding(navController)

                }
            }
            Row {
                repeat(3) {
                    CustomIndicator(isSelected = pagerState.currentPage == it)
                }
            }
        }
    }
}


@Composable
fun CustomIndicator(isSelected: Boolean) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(color = if (isSelected) Color.Black else Color.White, shape = CircleShape)
            .size(15.dp)
    )
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
fun OnBoardingScreenPreview() {
    val navController = rememberNavController()
    Box(modifier = Modifier.background(Color.White)) {
        OnBoardingScreen(navController)
    }
}

