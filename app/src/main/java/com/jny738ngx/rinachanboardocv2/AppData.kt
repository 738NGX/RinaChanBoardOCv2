package com.jny738ngx.rinachanboardocv2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jny738ngx.rinachanboardocv2.ui.theme.ThemeFamily

@Composable
fun rememberAppData(): AppData {
    // App设置
    val themeFamily = remember { mutableStateOf(ThemeFamily.Niji) }
    val useAutoTheme = remember { mutableStateOf(true) }

    // 璃奈板信息
    val isConnected = remember { mutableStateOf(false) }

    return remember {
        AppData(
            themeFamily,
            useAutoTheme,
            isConnected
        )
    }
}

data class AppData(
    val themeFamily: MutableState<ThemeFamily>,
    val useAutoTheme: MutableState<Boolean>,
    val isConnected: MutableState<Boolean>
)