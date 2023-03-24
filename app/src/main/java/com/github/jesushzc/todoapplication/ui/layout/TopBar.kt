package com.github.jesushzc.todoapplication.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.jesushzc.todoapplication.R

@Composable
@Preview
fun TopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Notes",
                style = MaterialTheme.typography.h5
            )
            Icon(
                modifier = Modifier.background(
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colors.background
                ).border(
                        width = 1.dp,
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(50)
                    ),
                painter = painterResource(id = R.drawable.icon_more),
                contentDescription = "Add",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}