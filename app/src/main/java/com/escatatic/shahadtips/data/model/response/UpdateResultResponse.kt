package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.base.BaseResponse
import com.escatatic.shahadtips.data.model.PickDataModel
import com.squareup.moshi.Json

data class UpdateResultResponse(
    override val success: Boolean,
    @field:Json(name = "updatedTip")
    override val data: PickDataModel
): BaseResponse<PickDataModel>()