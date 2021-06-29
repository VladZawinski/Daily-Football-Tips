package com.escatatic.shahadtips.home

import com.escatatic.shahadtips.base.BetStatus
import com.escatatic.shahadtips.data.model.request.UpdateScoreRequestBody
import com.escatatic.shahadtips.domain.repository.HomeRepository
import com.escatatic.shahadtips.home.uimodel.HomeViewEffect
import com.escatatic.shahadtips.home.uimodel.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: HomeRepository
): AndroidDataFlow(defaultState = HomeViewState()){

    init {
        fetchForTheFirstTime()
    }

    fun fetchForTheFirstTime() = action(
        onAction = { state ->
            setState { UIState.Loading }
            val result = repo.fetchPicks()
            setState {  (state as HomeViewState).copy(picks = result) }
        },
        onError = { error, _ ->
            sendEvent { HomeViewEffect.Failed(error.message!!) }
        }
    )

    fun markAsWin(id: String) = action {
        repo.markAsWin(id)
        sendEvent { HomeViewEffect.MarkedSuccessfully }
    }

    fun markAsLose(id: String) = action {
        repo.markAsLose(id)
        sendEvent { HomeViewEffect.MarkedSuccessfully }
    }

    fun updateGoals(home: Int, away: Int, id: String) = action {
        repo.updateGoals(home, away, id)
        sendEvent { HomeViewEffect.Updated }
    }

}