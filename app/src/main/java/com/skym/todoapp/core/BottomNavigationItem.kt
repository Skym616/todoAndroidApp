package com.skym.todoapp.core

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationItem(
    screen: AppRoute,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

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
                Color.Transparent,
                Color.Transparent
            ),
        )
    }

    val contentColor = if (selected) Color.White else Color.Black

    val icon = if (selected) screen.focusedIcon else screen.icon

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(brush = background)
            .clickable {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
    ) {

        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = screen.title,
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = contentColor
                )
            }
        }
    }
}
