package com.escatatic.shahadtips.home.match

import io.uniflow.core.flow.data.UIEvent

sealed class MatchViewEvent: UIEvent() {
    data class Failed(val message: String): MatchViewEvent()
    object MarkedSuccessfully: MatchViewEvent()
    object Updated: MatchViewEvent()
    object Loading: MatchViewEvent()
    object Refreshing: MatchViewEvent()
}