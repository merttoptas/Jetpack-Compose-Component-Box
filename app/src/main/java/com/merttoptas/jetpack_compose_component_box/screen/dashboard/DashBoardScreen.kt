package com.merttoptas.jetpack_compose_component_box.screen.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.buttons.CustomElevatedButton

@Composable
fun DashBoardScreen(
    navigateToButtons: () -> Unit,
    navigateToLoadings: () -> Unit,
    navigateToOtpScreen: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "DashBoard",
                elevation = 10.dp,
            )
        },
        content = {
            Content(
                navigateToButtons = {
                    navigateToButtons.invoke()
                },
                navigateToOtpScreen = {
                    navigateToOtpScreen.invoke()
                },
                navigateToLoadings = {
                    navigateToLoadings.invoke()
                }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
private fun Content(
    navigateToButtons: () -> Unit,
    navigateToOtpScreen: () -> Unit,
    navigateToLoadings: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CustomElevatedButton(onClick = navigateToButtons, text = "Buttons", textColor = Color.White)
        CustomElevatedButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = navigateToOtpScreen,
            text = "Otp",
            textColor = Color.White
        )
        CustomElevatedButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = navigateToLoadings,
            text = "Loadings",
            textColor = Color.White
        )
    }
}
