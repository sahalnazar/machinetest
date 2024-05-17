package com.sahalnazar.swiggymachinetest.presentation.screen.detail

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, viewModel: DetailScreenViewModel, movieId: String?) {
    val context = LocalContext.current
    LaunchedEffect(key1 = Unit, block = {
        Toast.makeText(context, "moviewID: $movieId", Toast.LENGTH_LONG).show()
        movieId?.let { viewModel.searchMovie(it) }
    })
    Scaffold(modifier = Modifier.fillMaxSize()) {
        val padding = it
        TextField(value = "", onValueChange = {})
    }
}