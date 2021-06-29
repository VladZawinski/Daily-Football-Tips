package com.escatatic.shahadtips.domain.repository

import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.domain.models.PicksByDate

interface HomeRepository {
    suspend fun fetchPicks(): List<PicksByDate>
    suspend fun markAsWin(id: String): Boolean
    suspend fun markAsLose(id: String): Boolean
    suspend fun updateGoals(home: Int,away: Int,id: String): Boolean
}