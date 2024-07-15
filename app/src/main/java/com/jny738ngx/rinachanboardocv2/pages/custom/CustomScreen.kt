package com.jny738ngx.rinachanboardocv2.pages.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.BoardGrid
import androidx.compose.ui.unit.dp
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanText
import com.jny738ngx.rinachanboardocv2.ui.components.BooleanUI
import com.jny738ngx.rinachanboardocv2.ui.components.MenuCard
import com.jny738ngx.rinachanboardocv2.ui.components.MenuIcon
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

@Composable
fun CustomScreen(appData: AppData) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        BoardGrid(appData, true)
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text("表情操作")
            Row {
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(0.dp, 5.dp, 5.dp, 5.dp)
                ) {
                    MenuIcon(Icons.AutoMirrored.Filled.Send)
                    Text("发送")
                }
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(5.dp),
                ) {
                    MenuIcon(Icons.Filled.Sync)
                    Text("同步")
                }
                MenuCard(
                    width = 110,
                    height = 50,
                    modifier = Modifier.padding(5.dp, 5.dp, 0.dp, 5.dp),
                    onClick = { appData.cells.forEach { cell -> cell.value = false } }
                ) {
                    MenuIcon(Icons.Filled.CleaningServices)
                    Text("清空")
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
fun CustomPreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        CustomScreen(appData)
    }
}