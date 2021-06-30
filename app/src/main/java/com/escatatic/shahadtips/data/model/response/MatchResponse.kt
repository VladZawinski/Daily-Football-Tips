package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.base.BaseResponse
import com.escatatic.shahadtips.data.model.PickDataModel

data class MatchResponse(
    override val success: Boolean,
    override val data: List<PickDataModel>
): BaseResponse<List<PickDataModel>>()