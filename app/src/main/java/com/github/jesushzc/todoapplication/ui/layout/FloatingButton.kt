package com.github.jesushzc.todoapplication.ui.layout

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.jesushzc.todoapplication.R

@Composable
@Preview
fun FloatingButton(
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = {
            onClick.invoke()
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_add),
            contentDescription = "Add"
        )
    }
}