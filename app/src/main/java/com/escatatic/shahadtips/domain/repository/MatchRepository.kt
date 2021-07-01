package com.escatatic.shahadtips.domain.repository

import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByTipster

interface MatchRepository {
    suspend fun findMatchesByDate(date: String): List<PicksByTipster>
    suspend fun markAsWin(id: String): Pick
    suspend fun markAsLose(id: String): Pick
    suspend fun updateGoals(home: Int,away: Int,id: String): Pick
    suspend fun addBadge(id: String,type: String): Pick
}