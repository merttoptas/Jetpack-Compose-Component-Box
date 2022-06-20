package com.merttoptas.jetpack_compose_component_box.screen.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.loading.CircularLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.HorizontalLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.StoryLoadingBar
import com.merttoptas.jetpack_compose_component_box.components.loading.ThinLoadingBar

@Composable
fun LoadingScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Loading",
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularLoadingBar()

        HorizontalLoadingBar()

        ThinLoadingBar()

        StoryLoadingBar()
    }
}
