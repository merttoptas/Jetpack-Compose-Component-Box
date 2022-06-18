package com.merttoptas.jetpack_compose_component_box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.buttons.CustomElevatedButton
import com.merttoptas.jetpack_compose_component_box.components.buttons.GradientButton
import com.merttoptas.jetpack_compose_component_box.ui.theme.JetpackComposeComponentBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentBoxTheme {
                val scaffoldState = rememberScaffoldState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState,
                        content = { Body() },
                    )

                }
            }
        }
    }
}

@Composable
private fun Body() {
    val content: @Composable (ColumnScope.() -> Unit) = {
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

        GradientButton(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {

        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp), content = content
    )
}