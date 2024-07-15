package com.jny738ngx.rinachanboardocv2.pages.voice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.BoardGrid
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

@Composable
fun VoiceScreen(appData: AppData) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        BoardGrid(appData)
        Text("这是预设语音")
    }
}

@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 1000
)
@Composable
fun VoicePreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        VoiceScreen(appData)
    }
}