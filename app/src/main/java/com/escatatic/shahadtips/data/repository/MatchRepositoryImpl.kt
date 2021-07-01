package com.escatatic.shahadtips.data.repository

import com.escatatic.shahadtips.base.BetStatus
import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.data.service.ShahadTipsService
import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByTipster
import com.escatatic.shahadtips.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val service: ShahadTipsService
): MatchRepository {

    override suspend fun findMatchesByDate(date: String): List<PicksByTipster> {
        val result = service.getMatchesByDate(date).data.map { it.map() }

        return result.groupBy { it.tipBy }.map {
            return@map PicksByTipster(it.key!!, it.value)
        }
    }

    override suspend fun markAsWin(id: String): Pick {
        return service.markAsWinOrLost(id, BetStatus.WIN).data.map()
    }

    override suspend fun markAsLose(id: String): Pick {
        return service.markAsWinOrLost(id, BetStatus.LOSE).data.map()
    }

    override suspend fun updateGoals(home: Int, away: Int, id: String): Pick {
        return service.updateScore(UpdateScoreRequestBody(id,home, away)).data.map()
    }

    override suspend fun addBadge(id: String, type: String): Pick {
        return service.giveBadge(id,type).data.map()
    }

}