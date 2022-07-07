package com.merttoptas.jetpack_compose_component_box.components.progressdialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun SimpleProgressDialog(
    modifier: Modifier = Modifier,
    message: String? = null,
    isCircular: Boolean = true,
    shape: Shape = RoundedCornerShape(10.dp),
    backgroundColor: Color = Color.White,
    elevation: Dp = 10.dp,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        ProgressDialogUI(
            modifier,
            message,
            isCircular,
            shape,
            backgroundColor,
            elevation,
        )
    }
}

@Composable
fun ProgressDialogUI(
    modifier: Modifier,
    message: String?,
    isCircular: Boolean,
    shape: Shape,
    backgroundColor: Color,
    elevation: Dp
) {
    Card(
        shape = shape,
        backgroundColor = backgroundColor,
        elevation = elevation,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(20.dp)
        ) {
            if (isCircular) {
                CircularProgressIndicator(strokeWidth = 1.dp)
            } else {
                LinearProgressIndicator()
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (message != null) {
                Text(text = message, style = MaterialTheme.typography.body1, fontSize = 12.sp)
            }
        }
    }
}


@Composable
@Preview
fun SimpleProgressDialogPreview() {
    SimpleProgressDialog(message = "Processing...") {}
}
