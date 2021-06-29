package com.escatatic.shahadtips.data.model

import com.escatatic.shahadtips.data.mapper.Mapper
import com.escatatic.shahadtips.domain.models.Goals

data class GoalsDataModel(
    val home: Int,
    val away: Int
): Mapper<Goals> {

    override suspend fun map(): Goals {
        return Goals(home, away)
    }
}