package com.moviles.examenmoviles.ui.screens

data class CoworkingSpace(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val isAvailable: Boolean,
    val imageUrl: String        // URL de imagen simulada
)