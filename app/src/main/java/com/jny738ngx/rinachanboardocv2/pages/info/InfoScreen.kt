package com.jny738ngx.rinachanboardocv2.pages.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.R
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.components.MenuImage
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

private const val infoScreenHeight = 1000

@Composable
fun InfoScreen(appData: AppData) {
    Column(
        modifier = Modifier
            .height(infoScreenHeight.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuImage(R.drawable.logo0, Modifier.size(300.dp))
    }
}

@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = infoScreenHeight
)
@Composable
fun InfoPreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        InfoScreen(appData)
    }
}