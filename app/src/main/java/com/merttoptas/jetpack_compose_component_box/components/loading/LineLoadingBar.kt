package com.merttoptas.jetpack_compose_component_box.components.loading

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThinLoadingBar(modifier: Modifier = Modifier) {
    LinearProgressIndicator(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(2.dp),
        backgroundColor = Color.LightGray,
        color = Color.Green
    )
}

@Preview
@Composable
fun ThinLoadingBarPreview(modifier: Modifier = Modifier) {
    LinearProgressIndicator(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(2.dp),
        backgroundColor = Color.LightGray,
        color = Color.Green,
        progress = 0.5F
    )
}