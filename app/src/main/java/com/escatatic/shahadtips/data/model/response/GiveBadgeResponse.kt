package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.base.BaseResponse
import com.escatatic.shahadtips.data.model.PickDataModel
import com.escatatic.shahadtips.domain.models.Pick
import com.squareup.moshi.Json

data class GiveBadgeResponse(
    override val success: Boolean,
    @field:Json(name = "updatedTip")
    override val data: PickDataModel
): BaseResponse<PickDataModel>()