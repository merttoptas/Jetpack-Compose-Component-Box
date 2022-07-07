package com.merttoptas.jetpack_compose_component_box.screen.progressdialog

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.buttons.CustomElevatedButton
import com.merttoptas.jetpack_compose_component_box.components.progressdialog.SimpleProgressDialog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ProgressDialogScreen(navigateToBack: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "Progress Dialog",
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
    val openDialog = remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(openDialog) {
        delay(2000)
        openDialog.value = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (openDialog.value) {
            SimpleProgressDialog(
                message = "Please wait...",
                onDismissRequest = {
                    openDialog.value = false
                }
            )
        }

        CustomElevatedButton(onClick = {
            openDialog.value = true
            scope.launch {
                delay(2000)
                openDialog.value = false
            }
        }, text = "Show Progress Dialog", textColor = Color.White)
    }
}
