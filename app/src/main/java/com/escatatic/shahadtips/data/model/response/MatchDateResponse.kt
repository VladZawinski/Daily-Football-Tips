package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.base.BaseResponse
import com.squareup.moshi.Json

data class MatchDateResponse(
    override val success: Boolean,
    @field:Json(name = "dates")
    override val data: List<String>
): BaseResponse<List<String>>()