package com.skym.todoapp.di

import androidx.room.Room
import com.skym.todoapp.data.database.TodoDatabase
import com.skym.todoapp.data.repository.TodoRepositoryImpl
import com.skym.todoapp.domain.repository.TodoRepository
import com.skym.todoapp.presentation.TodoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val TodoModule = module {

    single {
        val database = get<TodoDatabase>()
        database.todoDao()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            TodoDatabase::class.java,
            "todo_database",
        ).build()
    }

    single<TodoRepository> {
        TodoRepositoryImpl(get())
    }

    viewModel {
        TodoViewModel(get())
    }

}