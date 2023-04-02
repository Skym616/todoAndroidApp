package com.skym.todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import com.skym.todoapp.presentation.core.Spinner
import com.skym.todoapp.presentation.core.TodoItem
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController) {

    val viewModel = getViewModel<TodoViewModel>()

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screeHeight = LocalConfiguration.current.screenHeightDp

    val todo = Todo(
        title = "allez au marché",
        description = "fais les achats et les achats avec maman",
        complete = false,
        date = "05 OCT 2020",
        startTime = 21312312.toString(),
        endTime = 2134233232.toString(),
        id = null
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.addTodo(todo)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (screenWidth / 3).dp),
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                elevation = 0.dp
            ) {
                Text(
                    text = "Homepage",
                    style = MaterialTheme.typography.h1,
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .height((screeHeight / 5).dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colors.primaryVariant,
                                MaterialTheme.colors.primary,
                            ),
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Today's progress summary",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "13 tasks total",
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "progress 20%",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    LinearProgressIndicator(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.large)
                            .fillMaxWidth(),
                        progress = 0.9f,
                        backgroundColor = MaterialTheme.colors.background.copy(alpha = 0.6f),
                        color = MaterialTheme.colors.background
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Today's Task",
                    style = MaterialTheme.typography.h1
                )
                TextButton(
                    onClick = {},

                    ) {
                    Text(
                        text = "See All",
                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
                    )
                }
            }
            when (val allTodoResponse = viewModel.getAllTodoListResponse) {
                is Response.Loading -> Spinner()
                is Response.Success -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(allTodoResponse.data) { todo ->
                            TodoItem(todo = todo)
                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    }
                }
                is Response.Error -> {
                    Text(text = allTodoResponse.error)
                }
            }
        }
    }
}
