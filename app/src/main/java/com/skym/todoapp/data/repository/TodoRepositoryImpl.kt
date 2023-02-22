package com.skym.todoapp.data.repository

import com.skym.todoapp.data.dao.TodoDao
import com.skym.todoapp.domain.model.Response
import com.skym.todoapp.domain.model.Todo
import com.skym.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TodoRepositoryImpl(private val todoDao: TodoDao) : TodoRepository {

    override fun addTodo(todo: Todo): Flow<Response<String>> = flow {
        emit(Response.Loading)
        try {
            todoDao.insertTodo(todo)
            emit(Response.Success(todo.title))
        } catch (error: Exception) {
            emit(Response.Error(error.message!!))
        }
    }

    override fun getAllTodo(): Flow<Response<List<Todo>>> = flow {
        emit(Response.Loading)
        try {
            val todoList: List<Todo> = todoDao.getAllTodo()
            emit(Response.Success(todoList))
        } catch (error: Exception) {
            emit(Response.Error(error.message!!))
        }
    }

    override fun updateTodo(todo: Todo): Flow<Response<String>> {
        TODO("Not yet implemented")
    }

    override fun deleteTodo(idTodo: Int): Flow<Response<String>> {
        TODO("Not yet implemented")
    }
}