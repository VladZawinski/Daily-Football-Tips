package com.escatatic.shahadtips.data.model

import com.escatatic.shahadtips.data.mapper.Mapper
import com.escatatic.shahadtips.domain.models.Match

data class MatchDataModel(
    val home: String,
    val away: String
): Mapper<Match> {
    override suspend fun map(): Match {
        return Match(home, away)
    }

}