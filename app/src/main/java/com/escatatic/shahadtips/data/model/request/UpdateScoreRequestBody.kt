package com.escatatic.shahadtips.data.model.request

data class UpdateScoreRequestBody(
    val id: String,
    val home: Int,
    val away: Int
)