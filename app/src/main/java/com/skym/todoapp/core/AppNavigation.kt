package com.skym.todoapp.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.skym.todoapp.presentation.AddTodo
import com.skym.todoapp.presentation.DetailScreen
import com.skym.todoapp.presentation.Home

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppRoute.Home.route) {

        composable(route = AppRoute.Home.route) {
            Home(navController = navController)
        }

        composable(route = AppRoute.Detail.route) {
            DetailScreen()
        }

        composable(route = AppRoute.Add.route) {
            AddTodo()
        }
    }
}