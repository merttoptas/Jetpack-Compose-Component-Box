package com.merttoptas.jetpack_compose_component_box.components.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    query: String,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    border: BorderStroke = BorderStroke((0.5f).dp, MaterialTheme.colors.primary),
    backgroundColor: Color = MaterialTheme.colors.surface,
    shape: Shape = RoundedCornerShape(32.dp),
    elevation: Dp = 8.dp,
    onClearClick: () -> Unit = {},
    onQueryChanged: (String) -> Unit,
) {
    var showClearButton by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Card(
        elevation = elevation,
        modifier = modifier.padding(12.dp),
        border = border,
        backgroundColor = backgroundColor,
        shape = shape
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier.padding(start = 12.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colors.onSurface
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .onFocusChanged { focusState ->
                        showClearButton = (focusState.isFocused || query.isNotBlank())
                    },
                value = query,
                onValueChange = onQueryChanged,
                placeholder = {
                    Text(text = placeholderText, modifier = Modifier.wrapContentHeight())
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                ),
                trailingIcon = {
                    AnimatedVisibility(
                        visible = showClearButton,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = {
                            onClearClick()
                            focusManager.clearFocus()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                },
                maxLines = 1,
                singleLine = true
            )
        }
    }
}

@Composable
@Preview
fun SearchBarPreview() {
    SearchBar(query = "Android") {}
}