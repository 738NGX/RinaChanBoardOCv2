package com.jny738ngx.rinachanboardocv2.pages.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.R
import com.jny738ngx.rinachanboardocv2.data.defaultThemes
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.ExpandableCard
import com.jny738ngx.rinachanboardocv2.ui.components.MenuImage
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(appData: AppData) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuImage(R.drawable.logo0, Modifier.size(300.dp))
        ExpandableCard(
            title = "程序信息",
            icon = Icons.Filled.Android,
            width = 350,
            height = 50
        ) {
            Text("RinaChanBoard Operation Center V2")
            Text("璃奈板操作中心二代 v1.0.0")
            Text("开源协议：AGPL-3.0")
            Text("Github：738NGX/RinaChanBoardOCv2")
        }
        Spacer(modifier = Modifier.height(10.dp))
        ExpandableCard(
            title = "作者信息",
            icon = Icons.Filled.AccountCircle,
            width = 350,
            height = 50
        ) {
            Text("Developed by 738NGX")
            Text("一位来自上财的璃奈厨")
            Text("主页:https://www.738ngx.site/")
            Text("邮箱:jny738ngx@gmail.com")
        }
        Spacer(modifier = Modifier.height(10.dp))
        ExpandableCard(
            title = "应用设置",
            icon = Icons.Filled.Settings,
            width = 350,
            height = 50,
            expanded = true
        ) {
            Text("配色主题")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("使用自动配色主题")
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = appData.useAutoTheme.value,
                    modifier = Modifier.scale(0.75f),
                    onCheckedChange = { appData.useAutoTheme.value = it }
                )
            }
            Text("选择默认配色主题")
            SingleChoiceSegmentedButtonRow {
                defaultThemes.forEachIndexed { index, defaultTheme ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = defaultThemes.size,
                            baseShape = RoundedCornerShape(5.dp)
                        ),
                        onClick = { appData.defaultThemeFamily.value = defaultTheme.themeFamily },
                        modifier = Modifier.height(30.dp),
                        selected = appData.defaultThemeFamily.value == defaultTheme.themeFamily
                    ) {
                        Text(defaultTheme.name, style = TextStyle(fontSize = 10.sp))
                    }
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
fun InfoPreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        InfoScreen(appData)
    }
}

