package com.escatatic.shahadtips.home.uimodel

import io.uniflow.core.flow.data.UIEvent

sealed class HomeViewEffect: UIEvent() {
    object Loading: HomeViewEffect()
}