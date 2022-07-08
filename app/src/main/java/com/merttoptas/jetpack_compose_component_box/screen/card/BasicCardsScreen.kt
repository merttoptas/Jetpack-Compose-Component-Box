package com.merttoptas.jetpack_compose_component_box.screen.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.card.CustomBasicImageIconCard
import com.merttoptas.jetpack_compose_component_box.components.card.CustomBasicShareCard
import com.merttoptas.jetpack_compose_component_box.components.card.CustomBasicShareWithIconCard
import com.merttoptas.jetpack_compose_component_box.components.card.ExpandableCard
import com.merttoptas.jetpack_compose_component_box.components.cards.CustomHorizontalCard


@ExperimentalMaterialApi
@Composable
fun BasicCardsScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Basic Cards",
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
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 10.dp, vertical = 10.dp),
    ) {

        CustomHorizontalCard(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            imageUrl = "https://miro.medium.com/max/1400/1*u48XQeiEY0DGRQj8--EFyw.png",
            text = "Jetpack Compose",
            subtitleText = "Box",
            elevation = 5.dp
        )

        CustomBasicShareCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            onClick = {},
            imageUrl = "https://images.deliveryhero.io/image/fd-tr/LH/vs6i-hero.jpg",
            text = "1914 translation by H. Rackham",
            subtitleText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam fermentum, metus in malesuada aliquet, ex erat cursus nisl, sit amet molestie risus ligula ut magna. Aliquam erat volutpat."
        )

        CustomBasicShareWithIconCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "Aliquet Et Ante",
            onClickBookmark = {},
            onClickShare = {},
            imageUrl = "https://media.kingston.com/hyperx/category/hx-family-keyboard-alloy-origins-60-lg.jpg",
            onClickFavorite = {}
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomBasicImageIconCard(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .weight(0.5f),
                onClickBookmark = {},
                onClickShare = {},
                imageUrl = "https://media.kingston.com/hyperx/category/hx-family-keyboard-alloy-origins-60-lg.jpg",
                onClickFavorite = {},
                text = "Aliquet Et Ante",
            )
            CustomBasicImageIconCard(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp)
                    .weight(0.5f),
                onClickBookmark = {},
                onClickShare = {},
                imageUrl = "https://media.kingston.com/hyperx/category/hx-family-keyboard-alloy-origins-60-lg.jpg",
                onClickFavorite = {},
                text = "Aliquet Et Ante",
            )
        }

    }
}

