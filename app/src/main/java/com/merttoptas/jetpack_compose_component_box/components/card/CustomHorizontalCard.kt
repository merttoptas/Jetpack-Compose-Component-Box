package com.merttoptas.jetpack_compose_component_box.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merttoptas.jetpack_compose_component_box.components.image.CustomNetworkImage


// Horizontal Card with Image & Subtitle Text

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomHorizontalCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageUrl: String,
    text: String,
    subtitleText: String,
    backgroundColor: Color = Color.White,
    shape: Shape = MaterialTheme.shapes.large,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
        border = border,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomNetworkImage(
                imageURL = imageUrl,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
            )
            Text(
                text = text,
                modifier = Modifier.padding(start = 15.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = subtitleText, modifier = Modifier, style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}