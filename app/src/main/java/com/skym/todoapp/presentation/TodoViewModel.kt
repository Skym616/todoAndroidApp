package com.skym.todoapp.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import com.skym.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    var getAllTodoListResponse by mutableStateOf<Response<List<Todo>>>(Response.Loading)
        private set

    var deleteTodoResponse by mutableStateOf<Response<String>>(Response.Loading)
        private set

    init {
        getAllTodo()
    }

    private fun getAllTodo() = viewModelScope.launch {
        repository.getAllTodo().collect {
            getAllTodoListResponse = it
            Log.i("TODO", it.toString() + "Merkdee")
        }
    }

    fun addTodo(todo: Todo) = viewModelScope.launch {
        repository.addTodo(todo).collect {
            Log.i("TODO", it.toString() + "pourquoi")
        }
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch {
        repository.deleteTodo(todo).collect {
            deleteTodoResponse = it
        }
    }
}
