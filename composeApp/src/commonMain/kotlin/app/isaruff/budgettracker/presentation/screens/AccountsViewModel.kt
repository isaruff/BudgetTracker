package app.isaruff.budgettracker.presentation.screens

import app.isaruff.budgettracker.libs.core.mvi.NoEffect
import app.isaruff.budgettracker.libs.core.mvi.viewmodel.BaseMviViewModel
import app.isaruff.budgettracker.presentation.model.AmountUiModel
import app.isaruff.budgettracker.presentation.screens.accounts.event.AccountsUiEvent
import app.isaruff.budgettracker.presentation.screens.accounts.state.AccountsState

class AccountsViewModel : BaseMviViewModel<AccountsState, AccountsUiEvent, NoEffect>() {

    override val initialState: AccountsState = AccountsState(
        totalBalance = AmountUiModel.zero(),
        accounts = emptyList()
    )

    override fun handleEvent(event: AccountsUiEvent) {
        when (event) {
            AccountsUiEvent.OnAddAccount -> navigateToAddAccounts()
            AccountsUiEvent.OnBack -> navigateBack()
        }
    }

    private fun navigateBack() {
        TODO()
    }

    private fun navigateToAddAccounts() {
        TODO()
    }
}