package com.merttoptas.jetpack_compose_component_box.screen.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.R
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.buttons.CustomElevatedButton
import com.merttoptas.jetpack_compose_component_box.components.buttons.GradientButton
import com.merttoptas.jetpack_compose_component_box.components.buttons.OutlinedButton

@Composable
fun ButtonsScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Buttons",
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick = {
                        navigateToBack()
                    }) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {}
                },
            )
        },
        content = {
            Content()
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "Enabled",
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xffE5EADC)
            ),
            leadingIcon = Icons.Default.Add,
            iconTintColor = Color(0xff648A4F),
            textColor = Color(0xff648A4F),
        )

        GradientButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {}

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
        )
    }
}
