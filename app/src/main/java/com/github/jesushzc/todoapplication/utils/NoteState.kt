package com.github.jesushzc.todoapplication.utils

import com.github.jesushzc.todoapplication.domain.Notes

data class NoteState(
    val notes: List<Notes> = emptyList(),
    val isLoading: Boolean = false
)
