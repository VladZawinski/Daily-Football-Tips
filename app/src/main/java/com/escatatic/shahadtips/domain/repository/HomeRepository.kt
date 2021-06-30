package com.escatatic.shahadtips.domain.repository

import com.escatatic.shahadtips.domain.models.MatchDate

interface HomeRepository {
    suspend fun fetchMatchDates(): List<MatchDate>
}