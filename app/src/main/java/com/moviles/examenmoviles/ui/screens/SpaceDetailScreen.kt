package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.BottomBar
import com.moviles.examenmoviles.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = space.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back",
                            tint = AppPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBackground
                )
            )
        },
        bottomBar = {
            BottomBar(currentRoute = "spaces")  // ← visible también en detalle
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())  // scroll si el contenido es largo
        ) {
            // Imagen grande
            AsyncImage(
                model = space.imageUrl,
                contentDescription = space.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(20.dp)) {

                // Nombre + disponibilidad
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = space.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = AppPrimary
                    )
                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = if (space.isAvailable) AppGreen else AppRed
                    ) {
                        Text(
                            text = if (space.isAvailable) "Available" else "Unavailable",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppBackground,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Descripción completa
                Text(
                    text = space.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppSecondaryText
                )

                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = AppBorder)
                Spacer(modifier = Modifier.height(20.dp))

                // Info detallada
                DetailInfoRow(label = "Location", value = space.location)
                DetailInfoRow(label = "Capacity", value = "${space.capacity} people")
                DetailInfoRow(label = "Price per hour", value = "$${space.pricePerHour}")

                Spacer(modifier = Modifier.height(32.dp))

                // Botón de reserva
                AppButton(
                    text = "Reserve Space",
                    onClick = { },   // simulado — no requiere lógica real
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

// Componente reutilizable para cada fila de info
@Composable
private fun DetailInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = AppSecondaryText
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = AppPrimary
        )
    }
}