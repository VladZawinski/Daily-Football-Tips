package com.escatatic.shahadtips.data.repository

import com.escatatic.shahadtips.base.BetStatus
import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.data.service.ShahadTipsService
import com.escatatic.shahadtips.domain.models.PicksByDate
import com.escatatic.shahadtips.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: ShahadTipsService
): HomeRepository {

    override suspend fun fetchPicks(): List<PicksByDate> {
        val result =  service.fetchAllTips().tips.map { it.map() }

        return result.groupBy { it.dateOfTips }.map {
            return@map PicksByDate(it.key,it.value)
        }
    }

    override suspend fun markAsWin(id: String): Boolean {
        return service.markAsWinOrLost(id,BetStatus.WIN).success
    }

    override suspend fun markAsLose(id: String): Boolean {
        return service.markAsWinOrLost(id,BetStatus.LOSE).success
    }

    override suspend fun updateGoals(home: Int, away: Int, id: String): Boolean {
        return service.updateScore(UpdateScoreRequestBody(id,home, away)).success
    }


}