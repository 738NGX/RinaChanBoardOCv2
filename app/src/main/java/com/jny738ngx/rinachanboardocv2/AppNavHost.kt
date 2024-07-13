package com.jny738ngx.rinachanboardocv2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jny738ngx.rinachanboardocv2.pages.custom.CustomScreen
import com.jny738ngx.rinachanboardocv2.pages.home.HomeScreen
import com.jny738ngx.rinachanboardocv2.pages.info.InfoScreen
import com.jny738ngx.rinachanboardocv2.pages.music.MusicScreen
import com.jny738ngx.rinachanboardocv2.pages.voice.VoiceScreen

@Composable
fun AppNavHost(appData: AppData, navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(appData = appData)
        }
        composable(route = Custom.route) {
            CustomScreen()
        }
        composable(route = Voice.route) {
            VoiceScreen()
        }
        composable(route = Music.route) {
            MusicScreen()
        }
        composable(route = Info.route) {
            InfoScreen(appData = appData)
        }
    }
}