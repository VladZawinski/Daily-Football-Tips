package com.escatatic.shahadtips.data.repository

import com.escatatic.shahadtips.data.service.ShahadTipsService
import com.escatatic.shahadtips.domain.models.MatchDate
import com.escatatic.shahadtips.domain.repository.HomeRepository
import com.escatatic.shahadtips.extensions.changeToAppSpecificDate
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: ShahadTipsService
): HomeRepository {

    override suspend fun fetchMatchDates(): List<MatchDate> {
        return service.getMatchDates().data.map { MatchDate(it,it.changeToAppSpecificDate()) }
    }


}