package com.escatatic.shahadtips.home.match

import com.escatatic.shahadtips.domain.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val repo: MatchRepository
): AndroidDataFlow(defaultState = MatchViewState()){

    fun fetchByDate(date: String) = action(
        onAction = {
            sendEvent { MatchViewEvent.Loading }
            val result = repo.findMatchesByDate(date)
            Timber.d("$result")
            setState { (it as MatchViewState).copy(picks = result,currentDate = date) }
        }
    )

    fun refresh() = action {
        sendEvent { MatchViewEvent.Refreshing }
        val result = repo.findMatchesByDate((it as MatchViewState).currentDate)
        setState { it.copy(picks = result) }
    }

    fun markAsWin(id: String) = action {
        repo.markAsWin(id)
        sendEvent { MatchViewEvent.MarkedSuccessfully }
    }

    fun markAsLose(id: String) = action {
        repo.markAsLose(id)
        sendEvent { MatchViewEvent.MarkedSuccessfully }
    }

    fun updateGoals(home: Int, away: Int, id: String) = action {
        repo.updateGoals(home, away, id)
        sendEvent { MatchViewEvent.Updated }
    }

}