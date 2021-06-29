package com.escatatic.shahadtips.data.model.response

import com.escatatic.shahadtips.data.base.BaseResponse
import com.escatatic.shahadtips.data.model.PickDataModel

data class UpdateResultResponse(
    override val success: Boolean,
    override val data: PickDataModel
): BaseResponse<PickDataModel>()