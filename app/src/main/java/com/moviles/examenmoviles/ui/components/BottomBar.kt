package com.moviles.examenmoviles.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppNavUnselected
import com.moviles.examenmoviles.ui.theme.AppPrimary

// Recibe qué ítem está seleccionado actualmente
@Composable
fun BottomBar(currentRoute: String) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        NavigationBarItem(
            selected = currentRoute == "spaces",
            onClick = { },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Spaces") },
            label = { Text("Spaces") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppPrimary,
                selectedTextColor = AppPrimary,
                unselectedIconColor = AppNavUnselected,
                unselectedTextColor = AppNavUnselected,
                indicatorColor = AppBackground
            )
        )
        NavigationBarItem(
            selected = currentRoute == "calendar",
            onClick = { },
            icon = { Icon(Icons.Outlined.CalendarToday, contentDescription = "Calendar") },
            label = { Text("Calendar") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppPrimary,
                selectedTextColor = AppPrimary,
                unselectedIconColor = AppNavUnselected,
                unselectedTextColor = AppNavUnselected,
                indicatorColor = AppBackground
            )
        )
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { },
            icon = { Icon(Icons.Outlined.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AppPrimary,
                selectedTextColor = AppPrimary,
                unselectedIconColor = AppNavUnselected,
                unselectedTextColor = AppNavUnselected,
                indicatorColor = AppBackground
            )
        )
    }
}