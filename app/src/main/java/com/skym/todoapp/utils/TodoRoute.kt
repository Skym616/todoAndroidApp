package com.skym.todoapp.utils

sealed class TodoRoute(val route: String) {
    object MainScreen : TodoRoute(route = "home")
    object DetailScreen : TodoRoute(route = "detail")
}
