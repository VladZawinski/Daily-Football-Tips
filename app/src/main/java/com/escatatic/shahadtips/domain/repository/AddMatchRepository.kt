package com.escatatic.shahadtips.domain.repository

interface AddMatchRepository {
    suspend fun addMatch(home: String,away: String,tip: String,tipBy: String): String
}