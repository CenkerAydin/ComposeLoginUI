package com.cenkeraydin.composeloginui.ui.screen.data

import android.media.Image
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews : Boolean,
    val badgeCount: Int? =null
)
