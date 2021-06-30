package com.escatatic.shahadtips.data.repository

import com.escatatic.shahadtips.data.model.request.AddMatchRequestBody
import com.escatatic.shahadtips.data.service.ShahadTipsService
import com.escatatic.shahadtips.domain.repository.AddMatchRepository
import javax.inject.Inject

class AddMatchRepositoryImpl @Inject constructor(
    private val service: ShahadTipsService
): AddMatchRepository {

    override suspend fun addMatch(home: String, away: String, tip: String, tipBy: String): String {
        return service.addMatchManually(AddMatchRequestBody(home, away, tip, tipBy)).message
    }

}