package com.escatatic.shahadtips.data.model.request

data class AddMatchRequestBody(
    val home: String,
    val away: String,
    val tip: String,
    val tipBy: String
)