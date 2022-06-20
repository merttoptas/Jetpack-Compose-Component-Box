package com.merttoptas.jetpack_compose_component_box.components.loading


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StoryLoadingBar(
    modifier: Modifier = Modifier,
) {

    val progress = remember { Animatable(0F) }
    LaunchedEffect(true) {
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 5000,
                easing = LinearEasing
            )
        )
    }

    LinearProgressIndicator(
        modifier = modifier
            .padding(16.dp)
            .clip(CircleShape)
            .fillMaxWidth()
            .height(20.dp),
        backgroundColor = Color.DarkGray,
        color = Color.White,
        progress = progress.value
    )

}

@Preview
@Composable
fun StoryLoadingBarPreview() {
    LinearProgressIndicator(
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .fillMaxWidth()
            .height(20.dp),
        backgroundColor = Color.DarkGray,
        color = Color.White,
        progress = 0.5f
    )
}