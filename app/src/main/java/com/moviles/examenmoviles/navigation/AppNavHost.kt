package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moviles.examenmoviles.ui.screens.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.SpacesScreen
import com.moviles.examenmoviles.ui.screens.CoworkingSpace

object AppDestinations {
    const val SPACES = "spaces"
    const val DETAIL = "detail"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    // Guardamos el espacio seleccionado para pasarlo al detalle
    var selectedSpace by remember { mutableStateOf<CoworkingSpace?>(null) }

    NavHost(
        navController = navController,
        startDestination = AppDestinations.SPACES,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = AppDestinations.SPACES) {
            SpacesScreen(
                onSpaceClick = { space ->
                    selectedSpace = space
                    navController.navigate(AppDestinations.DETAIL)
                }
            )
        }

        composable(route = AppDestinations.DETAIL) {
            selectedSpace?.let { space ->
                SpaceDetailScreen(
                    space = space,
                    onBackClick = {
                        navController.popBackStack()  // regresa a la lista
                    }
                )
            }
        }
    }
}