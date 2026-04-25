package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.components.BottomBar
import com.moviles.examenmoviles.ui.theme.AppBackground

// Mock data — todos los campos del examen
val mockSpaces = listOf(
    CoworkingSpace(
        id = 1,
        name = "The Hub",
        description = "Modern open space with high-speed WiFi and natural lighting.",
        location = "Downtown, San José",
        capacity = 20,
        pricePerHour = 15.0,
        isAvailable = true,
        imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=800"
    ),
    CoworkingSpace(
        id = 2,
        name = "Zen Studio",
        description = "Quiet and minimalist workspace, ideal for focused work.",
        location = "Escazú, San José",
        capacity = 8,
        pricePerHour = 20.0,
        isAvailable = true,
        imageUrl = "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=800"
    ),
    CoworkingSpace(
        id = 3,
        name = "Tech Loft",
        description = "Fully equipped space with meeting rooms and standing desks.",
        location = "Heredia Centro",
        capacity = 35,
        pricePerHour = 12.0,
        isAvailable = false,
        imageUrl = "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?w=800"
    ),
    CoworkingSpace(
        id = 4,
        name = "Creative Nest",
        description = "Vibrant coworking with creative community and events.",
        location = "Alajuela Centro",
        capacity = 15,
        pricePerHour = 10.0,
        isAvailable = true,
        imageUrl = "https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=800"
    ),
    CoworkingSpace(
        id = 5,
        name = "Skyline Office",
        description = "Premium space on the 10th floor with panoramic city views.",
        location = "Sabana, San José",
        capacity = 50,
        pricePerHour = 30.0,
        isAvailable = false,
        imageUrl = "https://images.unsplash.com/photo-1486325212027-8081e485255e?w=800"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacesScreen(
    onSpaceClick: (CoworkingSpace) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Available Spaces",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBackground
                )
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "spaces")  // ← ítem Home seleccionado
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                start = 14.dp,
                end = 14.dp,
                top = 12.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mockSpaces, key = { it.id }) { space ->
                SpaceCard(
                    space = space,
                    onCardClick = { onSpaceClick(space) }  // navega al detalle
                )
            }
        }
    }
}