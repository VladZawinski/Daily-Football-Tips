package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.model.PickDataModel

data class PicksResponse(
    val success: Boolean,
    val tips: List<PickDataModel>
)