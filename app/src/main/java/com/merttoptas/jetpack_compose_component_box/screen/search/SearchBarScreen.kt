package com.merttoptas.jetpack_compose_component_box.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merttoptas.jetpack_compose_component_box.components.BackArrowIcon
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.components.CustomTopBar
import com.merttoptas.jetpack_compose_component_box.components.search.SearchBar

@Composable
fun SearchBarScreenContent() {

    var searchQuery by remember { mutableStateOf("") }
    val allOS by remember { mutableStateOf(getRandomGeneratedDummyPlatforms()) }
    var filteredOSList by remember { mutableStateOf(allOS) }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            modifier = Modifier,
            query = searchQuery,
            placeholderText = "Search",
            onQueryChanged = {
                searchQuery = it
                filteredOSList = allOS.filter { it.contains(searchQuery, true) }
            },
            onClearClick = {
                searchQuery = ""
                filteredOSList = allOS
            })

        PlatformList(filteredOSList)
    }

}

@Composable
fun PlatformList(OSList: List<String>) {
    if (OSList.isEmpty()) {
        Text(text = "No any OS that matches your query", color = Color.Red)
        return
    }

    LazyColumn(Modifier.fillMaxSize()) {
        items(OSList) {
            Text(text = it, modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun SearchScreen(navigateToBack: () -> Unit) {

    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar(
                text = "SearchBar Screen",
                elevation = 10.dp,
                navigationIcon = {
                    BackArrowIcon(onClick = { navigateToBack.invoke() })
                },
            )
        },
        content = {
            SearchBarScreenContent()
        }
    )

}


fun getRandomGeneratedDummyPlatforms(): List<String> {
    val osAndDescriptionsList = listOf(
        "Android",
        "Android is open to everyone: developers, designers and device makers.",
        "iOS",
        "iOS is created and developed by Apple Inc. It is the world's second-most widely installed mobile operating system, after Android. ",
        "Windows",
        "Windows is a graphical operating system developed and published by Microsoft.",
        "Linux",
        "MacOS"
    )

    val osRandomList = mutableListOf<String>()
    (0..100).forEach {
        osRandomList.add(
            osAndDescriptionsList[(0 until (osAndDescriptionsList.size)).random()]
        )
    }
    return osRandomList
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen {}
}
