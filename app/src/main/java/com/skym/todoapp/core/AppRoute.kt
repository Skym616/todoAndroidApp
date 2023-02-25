package com.skym.todoapp.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val focusedIcon: ImageVector
) {
    object Home : AppRoute(
        route = "home",
        title = "Home",
        icon = Icons.Outlined.Home,
        focusedIcon = Icons.Filled.Home
    )

    object Detail : AppRoute(
        route = "todo",
        title = "Todo",
        icon = Icons.Outlined.List,
        focusedIcon = Icons.Filled.List
    )

    object Add : AppRoute(
        route = "add",
        title = "Add",
        icon = Icons.Outlined.Add,
        focusedIcon = Icons.Filled.Add
    )
}
