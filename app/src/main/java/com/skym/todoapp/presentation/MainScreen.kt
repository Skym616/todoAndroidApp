package com.skym.todoapp.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.skym.todoapp.core.AppNavigation
import com.skym.todoapp.core.AppRoute
import com.skym.todoapp.core.BottomBarNavigation

@Composable
fun MainScreen() {

    val navHostController = rememberNavController()
    val navStackBackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    val selected = currentDestination?.hierarchy?.any { it.route == AppRoute.Add.route } == true

    val background = if (selected) {
        Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colors.primary,
                MaterialTheme.colors.primary.copy(alpha = 0.5f)
            ),
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colors.secondary,
                MaterialTheme.colors.secondary,
            ),
        )
    }

    val contentColor = Color.White

    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                BottomBarNavigation(navController = navHostController)
            }
        },
        floatingActionButton = {
            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .width(60.dp)
                    .height(60.dp)
                    .background(background)
                    .clickable {
                        navHostController.navigate(AppRoute.Add.route)
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = AppRoute.Add.icon,
                    contentDescription = AppRoute.Add.title,
                    tint = contentColor
                )
                AnimatedVisibility(visible = selected) {
                    Text(text = AppRoute.Add.title, color = contentColor)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = { padding ->
            AppNavigation(navController = navHostController)
        },
        modifier = Modifier.fillMaxSize()
    )
}