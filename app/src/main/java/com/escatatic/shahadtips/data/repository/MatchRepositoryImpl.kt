package com.escatatic.shahadtips.data.repository

import com.escatatic.shahadtips.base.BetStatus
import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.data.service.ShahadTipsService
import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val service: ShahadTipsService
): MatchRepository {

    override suspend fun findMatchesByDate(date: String): List<Pick> {
        return service.getMatchesByDate(date).data.map { it.map() }
    }

    override suspend fun markAsWin(id: String): Boolean {
        return service.markAsWinOrLost(id, BetStatus.WIN).success
    }

    override suspend fun markAsLose(id: String): Boolean {
        return service.markAsWinOrLost(id, BetStatus.LOSE).success
    }

    override suspend fun updateGoals(home: Int, away: Int, id: String): Boolean {
        return service.updateScore(UpdateScoreRequestBody(id,home, away)).success
    }

}