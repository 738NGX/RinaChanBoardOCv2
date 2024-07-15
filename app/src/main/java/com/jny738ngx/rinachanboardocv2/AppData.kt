package com.jny738ngx.rinachanboardocv2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.jny738ngx.rinachanboardocv2.data.BrightnessData
import com.jny738ngx.rinachanboardocv2.data.brightnessLevels
import com.jny738ngx.rinachanboardocv2.data.memberColors
import com.jny738ngx.rinachanboardocv2.ui.theme.ThemeFamily


@Composable
fun rememberAppData(): AppData {
    // App设置
    val defaultThemeFamily = remember { mutableStateOf(ThemeFamily.Niji) }
    val useAutoTheme = remember { mutableStateOf(true) }
    val themeFamily = remember { mutableStateOf(ThemeFamily.Niji) }

    // 璃奈板信息
    val isConnected = remember { mutableStateOf(false) }
    val brightness = remember { mutableStateOf(brightnessLevels[0]) }
    val color = remember { mutableStateOf(Color(0xfff971d4)) }
    val memberColorId = remember { mutableIntStateOf(399) }
    val cells = remember { List(288) { _ -> mutableStateOf(false) } }

    // 监听变化
    fun decideThemeColor() {
        if (useAutoTheme.value) {
            themeFamily.value =
                memberColors.filter { it.id == memberColorId.intValue }[0].themeFamily
        } else {
            themeFamily.value = defaultThemeFamily.value
        }
    }
    LaunchedEffect(useAutoTheme.value) {
        decideThemeColor()
    }
    LaunchedEffect(defaultThemeFamily.value) {
        decideThemeColor()
    }
    LaunchedEffect(memberColorId.intValue) {
        decideThemeColor()
        color.value = memberColors.filter { it.id == memberColorId.intValue }[0].color
    }

    return remember {
        AppData(
            defaultThemeFamily,
            useAutoTheme,
            themeFamily,
            isConnected,
            brightness,
            color,
            memberColorId,
            cells
        )
    }
}

data class AppData(
    val defaultThemeFamily: MutableState<ThemeFamily>,
    val useAutoTheme: MutableState<Boolean>,
    val themeFamily: MutableState<ThemeFamily>,
    val isConnected: MutableState<Boolean>,
    val brightness: MutableState<BrightnessData>,
    val color: MutableState<Color>,
    val memberColorId: MutableState<Int>,
    val cells: List<MutableState<Boolean>>
)