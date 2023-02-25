package com.skym.todoapp.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skym.todoapp.core.AppRoute
import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController) {

    val viewModel = getViewModel<TodoViewModel>()

    val todo = Todo(
        title = "allez au marché",
        content = "fais les achats et les achats",
        complete = false,
        id = null
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "home", modifier = Modifier.clickable {
                viewModel.addTodo(todo = todo)
            })
            when (val getTodosResponse = viewModel.getAllTodoListResponse) {
                is Response.Loading -> Text(text = "Loading...")
                is Response.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(getTodosResponse.data) { todo ->
                            Text(text = todo.title, modifier = Modifier.clickable {
                                viewModel.deleteTodo(todo)
                            })
                        }
                    }
                }
                is Response.Error -> Text(text = getTodosResponse.error)
            }
        }

        when (val deleteResponse = viewModel.deleteTodoResponse) {
            is Response.Loading -> Text(text = "Loading delete...")
            is Response.Success -> {
                Toast.makeText(
                    LocalContext.current,
                    "${deleteResponse.data} avec succes",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(AppRoute.Home.route)
            }
            is Response.Error -> Text(text = deleteResponse.error)
        }
    }
}
