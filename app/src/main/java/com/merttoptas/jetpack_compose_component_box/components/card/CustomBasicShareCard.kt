package com.merttoptas.jetpack_compose_component_box.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merttoptas.jetpack_compose_component_box.components.image.CustomNetworkImage

@ExperimentalMaterialApi
@Composable
fun CustomBasicShareCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageUrl: String,
    text: String,
    subtitleText: String,
    backgroundColor: Color = Color.White,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 5.dp,
    maxLines: Int = 3,
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
        border = border,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CustomNetworkImage(
                imageURL = imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(shape), contentScale = ContentScale.FillWidth
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        top = 10.dp,
                        end = 15.dp,
                        bottom = 10.dp
                    )
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = subtitleText,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    ),
                    maxLines = maxLines
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        top = 10.dp,
                        end = 15.dp,
                        bottom = 10.dp
                    ),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Share",
                    style = TextStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Explore",
                    style = TextStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}