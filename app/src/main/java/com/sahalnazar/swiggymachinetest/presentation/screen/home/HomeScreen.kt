package com.sahalnazar.swiggymachinetest.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sahalnazar.swiggymachinetest.presentation.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel) {
    val uiState = viewModel.uiState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize()) {
        val padding = it
        TextField(value = uiState.value.searchItem, onValueChange = {
            viewModel.setSearchItem(it)
        })

        LazyColumn(content = {
            uiState.value.searchResponse?.search?.forEach {
                item {
                    Card(onClick = {
                        navController.navigate(AppScreens.Detail.route + "/" + it?.imdbID)
                    }) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            AsyncImage(
                                model = it?.poster,
                                modifier = Modifier.weight(.4f),
                                contentDescription = null
                            )

                            Column {
                                Text(text = it?.title.orEmpty(), style = MaterialTheme.typography.bodyLarge)
                                Text(text = it?.type .orEmpty(), style = MaterialTheme.typography.bodyMedium)
                                Text(text = it?.year .orEmpty(), style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        })
    }
}