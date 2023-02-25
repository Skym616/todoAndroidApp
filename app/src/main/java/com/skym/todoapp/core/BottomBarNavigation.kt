package com.skym.todoapp.core

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBarNavigation(navController: NavHostController) {
    val screens = listOf(
        AppRoute.Home,
        AppRoute.Detail
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            BottomNavigationItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}