package com.skym.todoapp.data.dao

import androidx.room.*
import com.skym.todoapp.domain.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getAllTodo(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)
}