package com.skym.todoapp.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skym.todoapp.presentation.Home
import com.skym.todoapp.utils.TodoRoute

@Composable
fun TodoNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = TodoRoute.MainScreen.route) {

        composable(route = TodoRoute.MainScreen.route){
            Home()
        }

        composable(route = TodoRoute.DetailScreen.route) {

        }

    }
}