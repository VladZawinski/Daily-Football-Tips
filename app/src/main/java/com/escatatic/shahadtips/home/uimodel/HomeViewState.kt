package com.escatatic.shahadtips.home.uimodel

import com.escatatic.shahadtips.domain.models.MatchDate
import io.uniflow.core.flow.data.UIState

data class HomeViewState(
    val dates: List<MatchDate> = emptyList()
): UIState()