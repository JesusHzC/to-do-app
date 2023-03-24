package com.github.jesushzc.todoapplication.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.jesushzc.todoapplication.ui.utils.CircleProgress

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getPublicNotes()
    }
    val stateNotes = viewModel.publicNotes.collectAsState()

    stateNotes.value.let { state ->
        state.isLoading.let { isLoading ->
            if (isLoading) {
                CircleProgress()
            }
        }
        state.notes.let { notes ->
            if (notes.isEmpty() and state.isLoading.not()) {
                EmptyMessage()
            }
        }
    }
}

@Composable
fun EmptyMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "No notes found")
    }
}