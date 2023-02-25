package com.skym.todoapp.domain.repository

import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun addTodo(todo: Todo): Flow<Response<String>>
    fun getAllTodo(): Flow<Response<List<Todo>>>
    fun updateTodo(todo: Todo): Flow<Response<String>>
    fun deleteTodo(todo: Todo): Flow<Response<String>>
}