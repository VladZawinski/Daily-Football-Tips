package com.escatatic.shahadtips.home.match

import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByTipster
import io.uniflow.core.flow.data.UIState

data class MatchViewState(
    val picks: List<PicksByTipster> = emptyList(),
    val currentDate: String = ""
): UIState()