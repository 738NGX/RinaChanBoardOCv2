package com.jny738ngx.rinachanboardocv2.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.jny738ngx.rinachanboardocv2.AppDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWidget() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "璃奈版操作中心",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarColors(
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background
        )
    )
}

@Composable
fun BottomBarWidget(
    allScreens: List<AppDestination>,
    onTabSelected: (AppDestination) -> Unit,
    currentScreen: AppDestination
) {

    NavigationBar(
        containerColor = Color.White
    ) {
        allScreens.forEach { appScreen ->
            NavigationBarItem(
                selected = currentScreen == appScreen,
                onClick = {
                    onTabSelected(appScreen)
                },
                icon = { Icon(appScreen.icon, null) },
                label = { Text(text = appScreen.label) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
        }
    }
}