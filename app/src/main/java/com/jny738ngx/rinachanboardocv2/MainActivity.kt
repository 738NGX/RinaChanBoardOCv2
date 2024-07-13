package com.jny738ngx.rinachanboardocv2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.jny738ngx.rinachanboardocv2.ui.components.*
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    showBackground = true,
    showSystemUi = false,
)
@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = AppScreens.find { it.route == currentDestination?.route } ?: Home
    val appData = rememberAppData()

    RinaChanBoardOCv2Theme(appData.themeFamily) {
        Scaffold(
            topBar = { TopBarWidget() },
            bottomBar = {
                BottomBarWidget(
                    allScreens = AppScreens,
                    onTabSelected = { newScreen -> navController.navigate(newScreen.route) },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            AppNavHost(
                appData = appData,
                navController = navController,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}
