package com.jny738ngx.rinachanboardocv2.pages.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jny738ngx.rinachanboardocv2.R
import com.jny738ngx.rinachanboardocv2.ui.components.Indicator
import com.jny738ngx.rinachanboardocv2.ui.components.MenuCard
import com.jny738ngx.rinachanboardocv2.ui.components.MenuIcon
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.data.BrightnessLevel
import com.jny738ngx.rinachanboardocv2.data.MemberColor
import com.jny738ngx.rinachanboardocv2.data.brightnessLevels
import com.jny738ngx.rinachanboardocv2.data.defaultThemes
import com.jny738ngx.rinachanboardocv2.data.memberColors
import com.jny738ngx.rinachanboardocv2.data.toHex
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanText
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanUI
import com.jny738ngx.rinachanboardocv2.ui.components.LayoutType
import com.jny738ngx.rinachanboardocv2.ui.components.MenuImage

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(appData: AppData) {
    var selectingBrightness by remember { mutableStateOf(false) }
    var selectingColor by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
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

                BooleanText(appData.isConnected.value, "已连接", "已断开")
                Spacer(modifier = Modifier.weight(1f))
                BooleanUI(
                    appData.isConnected.value,
                    { Indicator(Color.Green) },
                    { Indicator(Color.Red) }
                )
                Spacer(modifier = Modifier.width(15.dp))
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
                height = -1,
                layoutType = LayoutType.Column,
                modifier = Modifier
                    .padding(0.dp, 5.dp)
                    .animateContentSize()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MenuIcon(Icons.Filled.LightMode)
                    Text("灯珠亮度:")
                    Text(appData.brightness.value.name)
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    )
                    Indicator(
                        when (appData.brightness.value.level) {
                            BrightnessLevel.Minimum -> Color.Black
                            BrightnessLevel.Low -> Color.DarkGray
                            BrightnessLevel.High -> Color.LightGray
                            BrightnessLevel.Maximum -> Color.White
                        }
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
                if (selectingBrightness) {
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 10.dp)
                    ) {
                        brightnessLevels.forEachIndexed { index, brightnessLevel ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(
                                    index = index,
                                    count = brightnessLevels.size,
                                    baseShape = RoundedCornerShape(5.dp)
                                ),
                                onClick = { appData.brightness.value = brightnessLevel },
                                modifier = Modifier.size(70.dp, 30.dp),
                                selected = appData.brightness.value.level == brightnessLevel.level
                            ) {
                                Text(brightnessLevel.name, style = TextStyle(fontSize = 10.sp))
                            }
                        }
                    }
                }
            }
            Row {
                MenuCard(
                    width = 130,
                    height = 50,
                    onClick = { selectingBrightness = !selectingBrightness },
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
                height = -1,
                layoutType = LayoutType.Column,
                modifier = Modifier
                    .padding(0.dp, 5.dp)
                    .animateContentSize()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MenuIcon(Icons.Filled.Palette)
                    Text("灯珠颜色:")
                    Text(appData.color.value.toHex())
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    )
                    Indicator(appData.color.value)
                    Spacer(modifier = Modifier.width(15.dp))
                }


                @Composable
                fun MemberColorSelector(
                    memberColor: MemberColor,
                    modifier: Modifier = Modifier.padding(5.dp, 0.dp)
                ) {
                    Surface(
                        modifier = modifier.size(20.dp),
                        shape = CircleShape,
                        color = memberColor.color,
                        onClick = { appData.memberColorId.value = memberColor.id }
                    ) {
                        if (appData.memberColorId.value == memberColor.id) {
                            Icon(
                                Icons.Filled.Check,
                                null,
                                modifier = Modifier.scale(0.8f),
                                tint = Color.White
                            )
                        }
                    }
                }

                @Composable
                fun MemberColorSelectorRow(
                    memberColorId: MutableState<Int>,
                    modifier: Modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 10.dp)
                ) {
                    val selectingMember =
                        memberColors.filter { it.id == memberColorId.value }[0]
                    Column(modifier = modifier) {
                        Text(selectingMember.memberName + ":" + selectingMember.colorName)
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                            memberColors.filter { it.themeFamily == selectingMember.themeFamily }
                                .forEach { memberColor ->
                                    MemberColorSelector(memberColor)
                                }
                        }
                    }
                }


                if (selectingColor) {
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
                    ) {
                        defaultThemes.forEachIndexed { index, defaultTheme ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(
                                    index = index,
                                    count = defaultThemes.size,
                                    baseShape = RoundedCornerShape(5.dp)
                                ),
                                onClick = {
                                    appData.memberColorId.value = (index + 1) * 100 + 1
                                },
                                modifier = Modifier.height(30.dp),
                                selected = appData.memberColorId.value / 100 == index + 1
                            ) {
                                Text(defaultTheme.name, style = TextStyle(fontSize = 10.sp))
                            }
                        }
                    }
                    MemberColorSelectorRow(appData.memberColorId)
                }
            }
            FlowRow {
                MenuCard(
                    width = 170,
                    height = 50,
                    onClick = { selectingColor = !selectingColor },
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
    heightDp = 1000
)
@Composable
fun HomePreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        HomeScreen(appData)
    }
}