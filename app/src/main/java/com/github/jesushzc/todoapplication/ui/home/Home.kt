package com.github.jesushzc.todoapplication.ui.home

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.jesushzc.todoapplication.domain.Notes
import com.github.jesushzc.todoapplication.ui.layout.MainLayout
import com.github.jesushzc.todoapplication.ui.utils.CircleProgress
import com.github.jesushzc.todoapplication.ui.utils.EmptyMessage

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getPublicNotes()
    }

    MainLayout {
        HomeContent(viewModel)
    }
}

@Composable
private fun HomeContent(
    viewModel: HomeViewModel
) {
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
            } else {
                NotesList(notes)
            }
        }
    }
}

@Composable
private fun NotesList(notes: List<Notes>) {
//    LazyVerticalGrid(columns = , content = )
}
