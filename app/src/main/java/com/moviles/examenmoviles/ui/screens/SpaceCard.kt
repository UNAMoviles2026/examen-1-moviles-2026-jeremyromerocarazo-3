package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
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
import com.moviles.examenmoviles.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
@Composable
fun SpaceCard(
    space: CoworkingSpace,
    onCardClick: () -> Unit,   // navega al detalle
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        border = BorderStroke(1.dp, AppBorder),
        colors = CardDefaults.cardColors(containerColor = AppSurface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        onClick = onCardClick
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // Imagen del espacio
            AsyncImage(
                model = space.imageUrl,
                contentDescription = space.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                // Nombre + badge de disponibilidad
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = space.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = AppPrimary
                    )
                    // Badge disponibilidad
                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = if (space.isAvailable) AppGreen else AppRed
                    ) {
                        Text(
                            text = if (space.isAvailable) "Available" else "Unavailable",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppBackground,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Descripción corta
                Text(
                    text = space.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppSecondaryText,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Fila: ubicación
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = AppIconTint,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = space.location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppSecondaryText
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Fila: capacidad + precio
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.People,
                            contentDescription = null,
                            tint = AppIconTint,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "${space.capacity} people",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppSecondaryText
                        )
                    }
                    Text(
                        text = "$${space.pricePerHour}/hr",
                        style = MaterialTheme.typography.titleMedium,
                        color = AppPrimary
                    )
                }
            }
        }
    }
}