package com.merttoptas.jetpack_compose_component_box.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by talhafaki on 18.06.2022.
 */

@Composable
fun OutlinedButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { },
        modifier = modifier,
        border = BorderStroke(1.dp, Color.Red),
        shape = RoundedCornerShape(50), // = 50% percent
        // or shape = CircleShape
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ){
        Text( text = "Outlined Button" )
    }
}

@Preview
@Composable
fun OutlinedButtonPreview() {
    OutlinedButton()
}