package com.escatatic.shahadtips.home.match

import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByDate
import io.uniflow.core.flow.data.UIState

data class MatchViewState(
    val picks: List<Pick> = emptyList(),
    val currentDate: String = ""
): UIState()