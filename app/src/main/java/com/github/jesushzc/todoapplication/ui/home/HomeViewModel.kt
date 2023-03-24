package com.github.jesushzc.todoapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jesushzc.todoapplication.repository.NotesRepository
import com.github.jesushzc.todoapplication.utils.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    private val _publicNotes: MutableStateFlow<NoteState> = MutableStateFlow(NoteState())
    val publicNotes: StateFlow<NoteState> = _publicNotes.asStateFlow()

    fun getPublicNotes() {
        _publicNotes.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val notes = repository.getAllPublic()
                _publicNotes.update {
                    it.copy(isLoading = false, notes = notes)
                }
            }
        }
    }

}