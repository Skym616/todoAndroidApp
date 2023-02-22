package com.skym.todoapp

import android.app.Application
import com.skym.todoapp.di.TodoModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TodoApplication)
            modules(listOf(TodoModule))
        }
    }
}