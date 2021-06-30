package com.escatatic.shahadtips.addmatch

import io.uniflow.core.flow.data.UIEvent

sealed class AddMatchViewEvent: UIEvent() {
    object Uploading: AddMatchViewEvent()
    object Success: AddMatchViewEvent()
    data class Error(val message: String): AddMatchViewEvent()
}