package com.merttoptas.jetpack_compose_component_box.screen.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.otp.CustomOtpContainer


@Composable
fun OtpScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Otp",
                elevation = 10.dp,
                navigationIcon = {
                    BackArrowIcon(navigateToBack)
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
    val otpValue = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomOtpContainer(value = otpValue.value, onValueChanged = {
            otpValue.value = it
        }, backgroundColor = Color(0xffF3F6FA))
    }
}
