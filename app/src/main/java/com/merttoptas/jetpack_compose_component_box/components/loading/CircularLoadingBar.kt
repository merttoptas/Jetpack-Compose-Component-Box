package com.merttoptas.jetpack_compose_component_box.components.loading

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircularLoadingBar(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
            .size(200.dp),
        color = Color.Green
    )
}

@Composable
@Preview
fun CircularLoadingBarPreview(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
            .size(200.dp),
        color = Color.Green,
        progress = 0.5F
    )
}