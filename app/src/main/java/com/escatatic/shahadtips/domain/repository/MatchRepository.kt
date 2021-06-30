package com.escatatic.shahadtips.domain.repository

import com.escatatic.shahadtips.domain.models.Pick

interface MatchRepository {
    suspend fun findMatchesByDate(date: String): List<Pick>
    suspend fun markAsWin(id: String): Boolean
    suspend fun markAsLose(id: String): Boolean
    suspend fun updateGoals(home: Int,away: Int,id: String): Boolean
}