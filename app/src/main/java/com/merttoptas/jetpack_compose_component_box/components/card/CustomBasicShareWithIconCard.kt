package com.merttoptas.jetpack_compose_component_box.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merttoptas.jetpack_compose_component_box.R
import com.merttoptas.jetpack_compose_component_box.components.image.CustomNetworkImage

@ExperimentalMaterialApi
@Composable
fun CustomBasicShareWithIconCard(
    modifier: Modifier = Modifier,
    onClickFavorite: () -> Unit,
    onClickBookmark: () -> Unit,
    onClickShare: () -> Unit,
    imageUrl: String,
    text: String,
    backgroundColor: Color = Color.White,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 5.dp,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
        border = border,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape)
            ) {
                CustomNetworkImage(
                    imageURL = imageUrl,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape), contentScale = ContentScale.Crop
                )

                Text(
                    text = text,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 20.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        end = 15.dp,
                    ),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onClickFavorite) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "Localized description",
                        tint = Color.Gray
                    )
                }

                IconButton(onClick = onClickShare, modifier = Modifier.padding(start = 20.dp)) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_bookmark_24),
                        contentDescription = "Bookmark",
                    )
                }

                IconButton(onClick = onClickBookmark, modifier = Modifier.padding(start = 20.dp)) {
                    Icon(
                        Icons.Default.Share,
                        contentDescription = "Share description",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}