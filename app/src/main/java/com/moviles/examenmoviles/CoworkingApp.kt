package com.moviles.examenmoviles

import androidx.compose.runtime.Composable
import com.moviles.examenmoviles.navigation.AppNavHost
import com.moviles.examenmoviles.ui.theme.CoworkingTheme

@Composable
fun CoworkingApp() {
    CoworkingTheme {
        AppNavHost()
    }
}