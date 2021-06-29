package com.escatatic.shahadtips.data.service

import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.data.model.response.PicksResponse
import com.escatatic.shahadtips.data.model.response.UpdateResultResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ShahadTipsService {
    @GET("api/tips/all")
    suspend fun fetchAllTips(): PicksResponse

    @POST("api/result/update")
    suspend fun markAsWinOrLost(
        @Query("id") id: String,
        @Query("markAs") markAs: String
    ): UpdateResultResponse

    @POST("api/score/update")
    suspend fun updateScore(
        @Body body: UpdateScoreRequestBody
    ): UpdateResultResponse
}