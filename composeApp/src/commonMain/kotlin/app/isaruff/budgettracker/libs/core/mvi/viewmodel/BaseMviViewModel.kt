package app.isaruff.budgettracker.libs.core.mvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.isaruff.budgettracker.libs.core.mvi.SideEffect
import app.isaruff.budgettracker.libs.core.mvi.UiEvent
import app.isaruff.budgettracker.libs.core.mvi.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseMviViewModel<State : UiState, Event : UiEvent, Effect : SideEffect>() : ViewModel() {

    protected abstract val initialState: State
    private val _uiState by lazy { MutableStateFlow(initialState) }
    val uiState by lazy { _uiState.asStateFlow() }

    private val _sideEffect = MutableSharedFlow<Effect>()
    val sideEffect = _sideEffect.asSharedFlow()

    protected abstract fun handleEvent(event: Event)

    fun sendEvent(event: Event) = ::handleEvent

    fun sendEffect(effect: Effect) = viewModelScope.launch(Dispatchers.Main.immediate) {
        _sideEffect.emit(effect)
    }
}