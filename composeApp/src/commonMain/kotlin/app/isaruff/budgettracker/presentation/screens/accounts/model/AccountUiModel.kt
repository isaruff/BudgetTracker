package app.isaruff.budgettracker.presentation.screens.accounts.model

import app.isaruff.budgettracker.presentation.model.AmountUiModel
import app.isaruff.budgettracker.presentation.model.IconUiModel

data class AccountUiModel(
    val id: String,
    val icon: IconUiModel,
    val name: String,
    val amount: AmountUiModel,
)
