package com.merttoptas.jetpack_compose_component_box.screen.card
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.card.ExpandableCard

@ExperimentalMaterialApi
@Composable
fun ExpandableCardScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Expandable Card",
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

@ExperimentalMaterialApi
@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 50.dp),
    ) {
        ExpandableCard(
            title = "Expandable Card",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing. Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
    }
}
