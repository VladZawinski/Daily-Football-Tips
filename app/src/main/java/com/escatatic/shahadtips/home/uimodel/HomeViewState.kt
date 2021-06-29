package com.escatatic.shahadtips.home.uimodel

import com.escatatic.shahadtips.domain.models.PicksByDate
import io.uniflow.core.flow.data.UIState

data class HomeViewState(
    val picks: List<PicksByDate> = emptyList()
): UIState()