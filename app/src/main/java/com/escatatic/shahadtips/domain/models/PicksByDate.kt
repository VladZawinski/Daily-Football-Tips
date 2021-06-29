package com.escatatic.shahadtips.domain.models

data class PicksByDate(
    val date: String,
    val data: List<Pick>
)