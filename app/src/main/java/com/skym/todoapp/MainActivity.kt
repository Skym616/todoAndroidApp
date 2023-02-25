package com.skym.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.skym.todoapp.presentation.MainScreen
import com.skym.todoapp.presentation.theme.TodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                MainScreen()
            }
        }
    }
}
