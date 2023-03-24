package com.github.jesushzc.todoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.github.jesushzc.todoapplication.ui.layout.MainLayout
import com.github.jesushzc.todoapplication.ui.navigation.Navigation
import com.github.jesushzc.todoapplication.ui.theme.ToDoApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoApplicationTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainLayout {
                        Navigation()
                    }
                }
            }
        }
    }
}