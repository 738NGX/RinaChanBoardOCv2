package com.jny738ngx.rinachanboardocv2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface AppDestination {
    val icon: ImageVector
    val label: String
    val route: String
}

data object Home : AppDestination {
    override val icon = Icons.Filled.Home
    override val label = "主页"
    override val route = "home"
}

data object Custom : AppDestination {
    override val icon = Icons.Filled.EmojiEmotions
    override val label = "自定表情"
    override val route = "custom"
}

data object Voice : AppDestination {
    override val icon = Icons.Filled.Mic
    override val label = "预设语音"
    override val route = "voice"
}

data object Music : AppDestination {
    override val icon = Icons.Filled.MusicNote
    override val label = "预设歌曲"
    override val route = "music"
}

data object Info : AppDestination {
    override val icon = Icons.Filled.Info
    override val label = "关于"
    override val route = "info"
}

val AppScreens= listOf(Home,Custom,Voice,Music,Info)