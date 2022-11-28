package com.merttoptas.jetpack_compose_component_box.screen.canvasviews.halfcirclepercentgraph

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.halfcirclepercentgraph.HalfCirclePercentGraph
import com.merttoptas.jetpack_compose_component_box.components.loading.CircularLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.HorizontalLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.StoryLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.ThinLoadingBar

/**
 * Created by merttoptas on 4.09.2022.
 */

@Composable
fun HalfCirclePercentGraphScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Half Circle Percent Graph",
                elevation = 10.dp,
                navigationIcon = {
                    BackArrowIcon(onClick = navigateToBack)
                },
            )
        },
        content = {
            Content()
        }
    )
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HalfCirclePercentGraph(
            modifier = Modifier.fillMaxWidth(),
            percentage = 0.80f,
            fillColor = MaterialTheme.colors.primary,
            backgroundColor = Color.Gray,
            strokeWidth = 30.dp
        )
    }
}
