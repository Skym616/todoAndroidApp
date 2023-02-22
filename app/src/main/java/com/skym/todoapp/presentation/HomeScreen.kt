package com.skym.todoapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.getViewModel

@Composable
fun Home() {

    val viewModel = getViewModel<TodoViewModel>()

    val todo = Todo(
        title = "allez au marcé",
        content = "fais les achats",
        complete = false,
        id = 1
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                when (val getTodosResponse = viewModel.getAllTodoListResponse) {
                    is Response.Loading -> Text(text = "Loading...")
                    is Response.Success -> {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(getTodosResponse.data.size) { todo ->
                                Text(text = todo.toString())
                            }
                        }
                    }
                    is Response.Error -> Text(text = getTodosResponse.error)
                }
                Text(text = "home", modifier = Modifier.clickable {
                    viewModel.addTodo(todo = todo)
                })
            }
        }
    }
}