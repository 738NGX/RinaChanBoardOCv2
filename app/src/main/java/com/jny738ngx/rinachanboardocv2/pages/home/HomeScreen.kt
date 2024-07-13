package com.jny738ngx.rinachanboardocv2.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jny738ngx.rinachanboardocv2.R
import com.jny738ngx.rinachanboardocv2.ui.components.Indicator
import com.jny738ngx.rinachanboardocv2.ui.components.MenuCard
import com.jny738ngx.rinachanboardocv2.ui.components.MenuIcon
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanText
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanUI
import com.jny738ngx.rinachanboardocv2.ui.components.MenuImage

private const val homeScreenHeight = 1000

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(appData: AppData) {
    Column(
        modifier = Modifier
            .height(homeScreenHeight.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BooleanUI(
            appData.isConnected.value,
            { MenuImage(R.drawable.connected, Modifier.size(300.dp)) },
            { MenuImage(R.drawable.disconnected, Modifier.size(300.dp)) }
        )
        Column {
            Text(
                text = "璃奈板通讯",
                modifier = Modifier.padding(0.dp, 5.dp)
            )
            MenuCard(
                width = 350,
                height = 70,
                modifier = Modifier.padding(0.dp, 5.dp)
            ) {
                MenuIcon(Icons.Filled.Link)
                Text("连接状态:")
                BooleanUI(
                    appData.isConnected.value,
                    { Indicator(Color.Green) },
                    { Indicator(Color.Red) }
                )
                BooleanText(appData.isConnected.value, "已连接", "已断开")
            }
            Row {
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(0.dp, 5.dp, 5.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Bluetooth)
                    Text("配对")
                }
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(5.dp),
                    onClick = { appData.isConnected.value = !appData.isConnected.value }
                ) {
                    BooleanUI(
                        appData.isConnected.value,
                        { MenuIcon(Icons.Filled.StopCircle) },
                        { MenuIcon(Icons.Filled.PlayCircle) }
                    )
                    BooleanText(appData.isConnected.value, "断开", "连接")
                }
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(5.dp, 5.dp, 0.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Wifi)
                    Text("测试")
                }
            }
        }
        Column {
            Text(
                text = "璃奈板设置",
                modifier = Modifier.padding(0.dp, 5.dp)
            )
            MenuCard(
                width = 350,
                height = 70,
                modifier = Modifier.padding(0.dp, 5.dp)
            ) {
                MenuIcon(Icons.Filled.LightMode)
                Text("灯珠亮度:")
                Indicator(Color.White)
                Text("光害")
            }
            Row {
                MenuCard(
                    width = 130,
                    height = 50,
                    modifier = Modifier.padding(0.dp, 5.dp, 5.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Menu)
                    Text("选择亮度")
                }
                MenuCard(
                    width = 100,
                    height = 50,
                    modifier = Modifier.padding(5.dp)
                ) {
                    MenuIcon(Icons.AutoMirrored.Filled.Send)
                    Text("发送")
                }
                MenuCard(
                    width = 100,
                    height = 50,
                    modifier = Modifier.padding(5.dp, 5.dp, 0.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Sync)
                    Text("同步")
                }
            }
            MenuCard(
                width = 350,
                height = 70,
                modifier = Modifier.padding(0.dp, 5.dp)
            ) {
                MenuIcon(Icons.Filled.Palette)
                Text("灯珠颜色:")
                Indicator(Color(0xfff971d4))
                Text("#F971D4")
            }
            FlowRow {
                MenuCard(
                    width = 170,
                    height = 50,
                    modifier = Modifier.padding(0.dp, 5.dp, 5.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Menu)
                    Text("从应援色选择")
                }
                MenuCard(
                    width = 170,
                    height = 50,
                    modifier = Modifier.padding(5.dp, 5.dp, 0.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Edit)
                    Text("自定义颜色")
                }
                MenuCard(
                    width = 170,
                    height = 50,
                    modifier = Modifier.padding(0.dp, 5.dp, 5.dp, 5.dp)
                ) {
                    MenuIcon(Icons.AutoMirrored.Filled.Send)
                    Text("发送颜色")
                }
                MenuCard(
                    width = 170,
                    height = 50,
                    modifier = Modifier.padding(5.dp, 5.dp, 0.dp, 5.dp)
                ) {
                    MenuIcon(Icons.Filled.Sync)
                    Text("同步颜色")
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = homeScreenHeight
)
@Composable
fun HomePreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        HomeScreen(appData)
    }
}