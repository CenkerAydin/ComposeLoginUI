package com.cenkeraydin.composeloginui.ui.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.composeloginui.R
import com.cenkeraydin.composeloginui.ui.screen.data.BottomNavigationItem
import com.cenkeraydin.composeloginui.ui.screen.login.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val loginViewModel: LoginViewModel = viewModel()

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Add",
            selectedIcon = Icons.Filled.Add,
            unselectedIcon = Icons.Outlined.Add,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TaskMaster") },
                navigationIcon = {
                    IconButton(
                        onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            loginViewModel.logoutUser()
                            navController.popBackStack()}) {
                        Image(
                            painter = painterResource(R.drawable.img_logout),
                            contentDescription ="logout" )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.title)
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) item.selectedIcon
                                    else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        })
                }
            }
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1C1C1E))
                .padding(paddingValues),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(9) { index ->
                when (index) {
                    0 -> CardContent(
                        title = "Yazılım.xyz",
                        content = "Stajyerlerin projeleri belirlenecek.",
                    )
                    1 -> CardContent(
                        title = "Kotlin",
                        content = "Kotlin basic çalışılacak.",
                    )
                    2 -> CardContent(
                        title = "Jetpack Compose",
                        content = "Jetpack Compose projesi yapılacak."
                    )
                    3 -> CardContent(
                        title = "Navigation",
                        content = "Navigation ile ilgili yazı yazılacak.",
                    )
                    4 -> CardContent(
                        title = "Dependency Injection",
                        content = "Dependency Injection hakkında video izlenecek."
                    )
                    5 -> CardContent(
                        title = "Password",
                        content = "Change password for the account.",
                    )
                    6 -> CardContent(
                        title = "Design",
                        content = "Design for the new project.",
                    )
                    7 -> CardContent(
                        title = "Proje",
                        content = "Proje için gerekli olan görseller belirlenecek.",
                    )
                }
            }
        }
    }
}

@Composable
fun CardContent(title: String, content: String, isCheckable: Boolean = false) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                overflow = TextOverflow.Clip,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            if (isCheckable) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = content.split("\n")[0], color = Color.Black)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = content.split("\n")[1], color = Color.Black)
                }
            } else {
                Text(
                    text = content,
                    color = Color.Black,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun CardImageContent(title: String, @DrawableRes imageRes: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}


