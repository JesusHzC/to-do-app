package com.github.jesushzc.todoapplication.ui.layout

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.jesushzc.todoapplication.ui.addnote.AddNoteBottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun MainLayout(
    content: @Composable (PaddingValues) -> Unit = {}
) {
    //bottom sheet state
    val stateBottomSheet = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            when (it) {
                ModalBottomSheetValue.Hidden -> true
                ModalBottomSheetValue.HalfExpanded -> true
                ModalBottomSheetValue.Expanded -> true
            }
        }
    )

    val coroutineScope = rememberCoroutineScope()

    //handle back button for hide bottom sheet
    BackHandler(stateBottomSheet.isVisible) {
        coroutineScope.launch {
            stateBottomSheet.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = stateBottomSheet,
        sheetContent = {
            AddNoteBottomSheet()
        },
        modifier = Modifier.fillMaxSize(),
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar() },
                floatingActionButton = { FloatingButton {
                    //show bottom sheet
                    coroutineScope.launch {
                        if (stateBottomSheet.isVisible) stateBottomSheet.hide()
                        else stateBottomSheet.show()
                    }
                } },
                content = content
            )
        }
    )
}