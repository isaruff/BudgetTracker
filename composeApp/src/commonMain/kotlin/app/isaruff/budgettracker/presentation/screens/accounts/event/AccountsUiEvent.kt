package app.isaruff.budgettracker.presentation.screens.accounts.event

import app.isaruff.budgettracker.libs.core.mvi.UiEvent

sealed interface AccountsUiEvent : UiEvent {
    data object OnBack : AccountsUiEvent

    data object OnAddAccount : AccountsUiEvent
}