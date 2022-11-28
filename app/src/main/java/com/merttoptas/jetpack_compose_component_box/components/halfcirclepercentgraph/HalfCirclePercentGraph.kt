package com.merttoptas.jetpack_compose_component_box.components.halfcirclepercentgraph

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * Created by merttoptas on 4.09.2022.
 */

@Composable
fun HalfCirclePercentGraph(
    modifier: Modifier,
    percentage: Float,
    fillColor: Color,
    backgroundColor: Color,
    strokeWidth: Dp = 1.dp,
) {
    // Create a state to hold the current progress
    val animateFloat = remember { Animatable(0f) }
    // Percentage value to be animated
    var percentageValue by remember { mutableStateOf(0) }

    // Animate the percentage value
    val animatePercentageValue by animateIntAsState(
        targetValue = percentageValue,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
    )


    LaunchedEffect(animateFloat) {
        delay(500)
        percentageValue = (percentage * 100).toInt()

        // If you wish change the animation duration, you can change the durationMillis value
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
        )
    }

    val configuration = LocalConfiguration.current
    // Get device screen witch because we will use it for drawing the circle
    val screenWidth = configuration.screenWidthDp

    Box(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 30.dp)
            .height(200.dp)
    ) {
        Canvas(
            modifier = modifier
                .size((screenWidth * 0.5f).toInt().dp)

        ) {
            // Background Line
            drawArc(
                color = backgroundColor,
                -180f,
                180f,
                false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
                size = Size(size.width, size.height * 2)
            )
            // Fill Line
            drawArc(
                color = fillColor,
                startAngle = -180F,
                sweepAngle = percentage * 180f * animateFloat.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
                size = Size(size.width, size.height * 2)
            )
        }
        Column(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${animatePercentageValue}%",
                color = MaterialTheme.colors.primary,
                fontSize = 28.sp
            )
            Text(
                text = "Component Box",
                color = MaterialTheme.colors.primary,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewHalfCirclePercentGraph() {
    HalfCirclePercentGraph(
        modifier = Modifier,
        percentage = 0.3f,
        fillColor = Color.Red,
        backgroundColor = Color.Gray,
        strokeWidth = 30.dp
    )
}