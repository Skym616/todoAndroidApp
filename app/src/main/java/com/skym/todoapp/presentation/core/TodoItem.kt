package com.skym.todoapp.presentation.core

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.skym.todoapp.domain.model.Todo

@Composable
fun TodoItem(todo: Todo) {
    var color by remember {
        mutableStateOf<Int>(Color.WHITE)
    }

    color = if (!todo.complete) {
        Color.GREEN
    } else {
        Color.RED
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp,
        color = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = todo.title, style = MaterialTheme.typography.h2)
                Text(
                    text = "${todo.startTime} - ${todo.endTime}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }

}