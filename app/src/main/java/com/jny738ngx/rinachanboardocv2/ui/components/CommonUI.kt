package com.jny738ngx.rinachanboardocv2.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement

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
    modifier: Modifier = Modifier
) {
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
    elevation: Int = 0,
    color: Color = MaterialTheme.colorScheme.surfaceContainer,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        color = color,
        shadowElevation = elevation.dp,
        modifier = if (height < 0) {
            modifier.width(width.dp)
        } else {
            modifier.size(width.dp, height.dp)
        },
        onClick = onClick
    ) {
        when (layoutType) {
            LayoutType.Row -> Row(verticalAlignment = Alignment.CenterVertically) { content() }
            LayoutType.Column -> Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) { content() }
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
private fun Expandable(
    width: Int,
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    onExpandChanged: (Boolean) -> Unit,
    leading: @Composable (RowScope.() -> Unit)? = null,
    title: @Composable (RowScope.() -> Unit)? = null,
    expand: @Composable (RowScope.(modifier: Modifier) -> Unit)? = null,
    content: @Composable () -> Unit,
    contentAnimation: FiniteAnimationSpec<IntSize> = tween(
        durationMillis = 300,
        easing = LinearOutSlowInEasing
    ),
    expandAnimation: State<Float> = animateFloatAsState(
        targetValue = if (expanded.value) 180f else 0f, label = ""
    )
) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier = modifier
            .width(width.dp)
            .animateContentSize(animationSpec = contentAnimation)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .clickable { onExpandChanged(!expanded.value) }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                leading?.let {
                    it()
                }
                title?.let {
                    it()
                }
                Spacer(modifier = Modifier.weight(1f))
                expand?.let {
                    it(
                        Modifier.rotate(expandAnimation.value),
                    )
                } ?: run {
                    Icon(
                        modifier = Modifier
                            .rotate(expandAnimation.value),
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            AnimatedVisibility(
                visible = expanded.value,
                enter = expandVertically(animationSpec = contentAnimation),
                exit = shrinkVertically(animationSpec = contentAnimation)
            ) {
                content()
            }
        }
    }
}

@Composable
fun ExpandableCard(
    title: String,
    icon: ImageVector,
    width: Int,
    height: Int,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    content: @Composable () -> Unit
) {
    val expanded1 = remember { mutableStateOf(expanded) }

    Expandable(
        width = width,
        modifier = modifier,
        expanded = expanded1,
        onExpandChanged = {
            expanded1.value = it
        },
        leading = {
            Icon(
                modifier = Modifier,
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.inversePrimary
            )
            Spacer(modifier = Modifier.size(10.dp, height.dp))
        },
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        content = {
            Column(Modifier.padding(10.dp)) {
                content()
            }
        },
    )
}
