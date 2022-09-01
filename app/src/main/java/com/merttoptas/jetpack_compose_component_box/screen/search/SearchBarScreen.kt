package com.merttoptas.jetpack_compose_component_box.screen.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar

@Composable
fun SearchBarScreenContent() {

}


@Composable
fun SearchScreen(navigateToBack: () -> Unit) {

    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "SearchBar Screen",
                elevation = 10.dp,
                navigationIcon = {
                    BackArrowIcon(onClick = { navigateToBack.invoke() })
                },
            )
        },
        content = {
            SearchBarScreenContent()
        }
    )

}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen {}
}
