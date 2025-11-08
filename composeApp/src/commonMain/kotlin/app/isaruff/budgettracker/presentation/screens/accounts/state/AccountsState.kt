package app.isaruff.budgettracker.presentation.screens.accounts.state

import app.isaruff.budgettracker.libs.core.mvi.UiState
import app.isaruff.budgettracker.presentation.model.AmountUiModel
import app.isaruff.budgettracker.presentation.screens.accounts.model.AccountUiModel

data class AccountsState(
    val totalBalance: AmountUiModel,
    val accounts: List<AccountUiModel>
) : UiState