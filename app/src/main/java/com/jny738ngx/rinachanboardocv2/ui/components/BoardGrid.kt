package com.jny738ngx.rinachanboardocv2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.jny738ngx.rinachanboardocv2.AppData
import com.jny738ngx.rinachanboardocv2.rememberAppData
import com.jny738ngx.rinachanboardocv2.ui.theme.RinaChanBoardOCv2Theme

private const val cell_size = 18

@Composable
fun BoardGridCell(
    appData: AppData,
    clickable: Boolean,
    id: Int
) {
    val cellState by remember { appData.cells[id] }
    val cellColor = if (cellState) {
        appData.color.value
    } else {
        Color.White
    }
    Surface(
        color = cellColor,
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(0.1.dp, Color.Black),
        modifier = remember { Modifier.size(cell_size.dp) }
            .then(
                if (clickable) {
                    Modifier.clickable { appData.cells[id].value = !cellState }
                } else {
                    Modifier
                }
            )
    ) {}
}

@Composable
fun BoardGrid(appData: AppData, clickable: Boolean = false) {
    Surface(
        color = Color(0xff37bcdb),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(350.dp,(17.5 * cell_size).dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(18),
            modifier = Modifier.padding(10.dp),
            verticalArrangement=Arrangement.Center
        ) {
            itemsIndexed(appData.cells) { id, _ ->
                key(id){ BoardGridCell(appData, clickable, id) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardGridPreview() {
    val appData = rememberAppData()
    RinaChanBoardOCv2Theme(appData.themeFamily) {
        BoardGrid(appData, true)
    }
}