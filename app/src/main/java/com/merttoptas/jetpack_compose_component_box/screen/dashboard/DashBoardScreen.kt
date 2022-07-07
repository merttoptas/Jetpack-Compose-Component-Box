package com.merttoptas.jetpack_compose_component_box.screen.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
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
    navigateToOtpScreen: () -> Unit,
    navigateToExpandableCardScreen: () -> Unit
    navigateToProgressDialogScreen : () -> Unit,
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
                },
                navigateToExpandableCardScreen = {
                    navigateToExpandableCardScreen.invoke()
                navigateToProgressDialogScreen = {
                    navigateToProgressDialogScreen.invoke()
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
    navigateToExpandableCardScreen: () -> Unit

    navigateToProgressDialogScreen : () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
        CustomElevatedButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = navigateToExpandableCardScreen,
            text = "Expandable Card",
            textColor = Color.White
        )
        CustomElevatedButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = navigateToProgressDialogScreen,
            text = "Progress Dialog",
            textColor = Color.White
        )
    }
}
