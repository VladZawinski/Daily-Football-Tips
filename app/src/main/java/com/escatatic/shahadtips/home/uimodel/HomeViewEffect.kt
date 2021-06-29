package com.escatatic.shahadtips.home.uimodel

import io.uniflow.core.flow.data.UIEvent

sealed class HomeViewEffect: UIEvent() {
    data class Failed(val message: String): HomeViewEffect()
    object MarkedSuccessfully: HomeViewEffect()
    object Updated: HomeViewEffect()
}