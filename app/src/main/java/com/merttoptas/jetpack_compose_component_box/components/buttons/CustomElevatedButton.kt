package com.merttoptas.jetpack_compose_component_box.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.Black,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevation(5.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    shape: RoundedCornerShape = RoundedCornerShape(50),
    leadingIcon: ImageVector? = null,
    iconTintColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {

    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        enabled = enabled,
        elevation = elevation,
        colors = colors,
        shape = shape
    ) {
        if (leadingIcon != null) {
            Icon(
                leadingIcon,
                "menu",
                modifier = Modifier.padding(horizontal = 5.dp),
                tint = iconTintColor
            )
        }
        Text(text = text, color = textColor)
    }
}