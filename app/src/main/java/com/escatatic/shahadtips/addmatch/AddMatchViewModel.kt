package com.escatatic.shahadtips.addmatch

import com.escatatic.shahadtips.domain.repository.AddMatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import javax.inject.Inject

@HiltViewModel
class AddMatchViewModel @Inject constructor(
    private val repo: AddMatchRepository
): AndroidDataFlow(){

    fun addMatch(
        home: String,
        away: String,
        tip: String,
        tipBy: String
    ) = action (
        onAction = {
            sendEvent { AddMatchViewEvent.Uploading }
            repo.addMatch(home, away, tip, tipBy)
            sendEvent { AddMatchViewEvent.Success }
        },
        onError = { error, _ ->
            sendEvent { AddMatchViewEvent.Error(error.message!!) }
        }
    )
}