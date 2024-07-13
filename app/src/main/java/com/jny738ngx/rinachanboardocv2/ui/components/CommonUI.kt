package com.jny738ngx.rinachanboardocv2.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

enum class LayoutType { Row, Column }

@Composable
fun MenuIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.inversePrimary
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        modifier = modifier.padding(15.dp),
        tint = tint
    )
}

@Composable
fun MenuImage(
    @DrawableRes id: Int,
    modifier: Modifier=Modifier
){
    Image(
        painterResource(id),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun MenuCard(
    width: Int,
    height: Int,
    modifier: Modifier = Modifier,
    layoutType: LayoutType = LayoutType.Row,
    elevation: Int = 2,
    color: Color = MaterialTheme.colorScheme.surfaceContainer,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        color = color,
        shadowElevation = elevation.dp,
        modifier = modifier.size(width.dp, height.dp),
        onClick = onClick
    ) {
        when (layoutType) {
            LayoutType.Row -> Row(verticalAlignment = Alignment.CenterVertically) { content() }
            LayoutType.Column -> Column(horizontalAlignment = Alignment.CenterHorizontally) { content() }
        }
    }
}

@Composable
fun Indicator(color: Color) {
    Surface(
        modifier = Modifier
            .size(30.dp, 20.dp)
            .padding(5.dp, 0.dp),
        shape = CircleShape,
        color = color,
        border = BorderStroke(1.dp, Color.Black)
    ) {}
}

@Composable
fun BooleanText(case: Boolean, trueStr: String, falseStr: String) {
    Text(
        when (case) {
            false -> falseStr
            true -> trueStr
        }
    )
}

@Composable
fun BooleanUI(case: Boolean, trueUI: @Composable () -> Unit, falseUI: @Composable () -> Unit) {
    when (case) {
        false -> falseUI()
        true -> trueUI()
    }
}

@Composable
fun ExpandableCard(
    title: String,
    width: Int,
    height: Int
) {
    val expanded by remember { mutableStateOf (false) }
    MenuCard(
        width=width,
        height=height
    ) {
        Column{
            Text(
                text = title,
                modifier = Modifier.padding(8.dp)
            )
            if (expanded) {
                Text(
                    text = "Content Sample for Display on Expansion of Card",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

