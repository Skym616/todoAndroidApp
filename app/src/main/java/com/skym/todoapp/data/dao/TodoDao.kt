package com.skym.todoapp.data.dao

import androidx.room.*
import com.skym.todoapp.domain.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    suspend fun getAllTodo(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}