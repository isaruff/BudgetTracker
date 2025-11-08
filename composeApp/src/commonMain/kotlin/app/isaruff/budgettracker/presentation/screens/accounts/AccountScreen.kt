@file:OptIn(ExperimentalMaterial3Api::class)

package app.isaruff.budgettracker.presentation.screens.accounts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.isaruff.budgettracker.presentation.model.AmountUiModel
import app.isaruff.budgettracker.presentation.model.IconUiModel
import app.isaruff.budgettracker.presentation.screens.accounts.event.AccountsUiEvent
import app.isaruff.budgettracker.presentation.screens.accounts.model.AccountUiModel
import app.isaruff.budgettracker.presentation.screens.accounts.state.AccountsState
import app.isaruff.budgettracker.presentation.ui_toolkit.components.button.NBButton
import app.isaruff.budgettracker.presentation.ui_toolkit.components.button.NBIconButton
import app.isaruff.budgettracker.presentation.ui_toolkit.components.container.core.static.NBContainer
import app.isaruff.budgettracker.presentation.ui_toolkit.components.icon.NBIcon
import app.isaruff.budgettracker.presentation.ui_toolkit.components.item.NBListItem
import app.isaruff.budgettracker.presentation.ui_toolkit.components.toolbar.NBSingleRowTopBar
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.AppTheme
import app.isaruff.budgettracker.presentation.ui_toolkit.theme.LexendMegaFontFamily
import budgettracker.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun AccountsScreen(
    state: AccountsState,
    onUiEvent: (AccountsUiEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.color.background,
        topBar = {
            Toolbar(
                onBack = {
                    onUiEvent(AccountsUiEvent.OnBack)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            AccountNetBalance(
                netBalance = state.totalBalance
            )
            AccountsList(
                modifier = Modifier.weight(1f),
                accounts = state.accounts,
                onClickAccount = {}
            )
        }

    }
}

@Composable
private fun Toolbar(onBack: () -> Unit) {
    NBSingleRowTopBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = stringResource(Res.string.title_accounts)
            )
        },
        navigationIcon = {
            NBIconButton(
                iconRes = Res.drawable.ic_arrow_left,
                onClick = onBack,
                background = AppTheme.color.tertiary
            )
        },
        actions = {
            NBButton(
                modifier = Modifier.width(IntrinsicSize.Min),
                text = stringResource(Res.string.action_add),
                contentColor = AppTheme.color.onPrimary,
                background = AppTheme.color.primary,
                onClick = {

                }
            )
        }
    )
}

@Composable
private fun AccountNetBalance(
    netBalance: AmountUiModel,
    modifier: Modifier = Modifier
) {
    NBContainer(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.dimens.spacingSm),
        background = AppTheme.color.secondary
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(AppTheme.dimens.spacingMd),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.label_total_balance),
                style = AppTheme.typography.headlineMedium
            )
            Text(
                text = netBalance.formattedAmount(),
                fontFamily = LexendMegaFontFamily,
                style = AppTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
private fun AccountsList(
    accounts: List<AccountUiModel>,
    modifier: Modifier = Modifier,
    onClickAccount: (AccountUiModel) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingSm),
        contentPadding = PaddingValues(AppTheme.dimens.spacingSm)
    ) {
        items(accounts) { item ->
            AccountItem(
                model = item,
                onClick = onClickAccount
            )
        }
    }
}

@Composable
private fun AccountItem(
    model: AccountUiModel,
    modifier: Modifier = Modifier,
    onClick: (AccountUiModel) -> Unit,
) {
    NBListItem(
        modifier = modifier,
        leadingContent = {
            NBIcon(
                iconRes = model.icon.icon,
                tint = model.icon.tint,
                background = model.icon.backgroundColor
            )
        },
        headlineContent = {
            Text(
                text = model.name,
            )
        },
        supportingContent = {
            Text(
                text = model.amount.formattedAmount()
            )
        },
        onClick = { onClick(model) }
    )
}

@Preview
@Composable
private fun AccountsScreenPrev(
    @PreviewParameter(AccountsScreenStateProvider::class) state: AccountsState
) {
    AppTheme {
        AccountsScreen(
            state = state,
            onUiEvent = {}
        )
    }
}

private class AccountsScreenStateProvider : PreviewParameterProvider<AccountsState> {
    override val values: Sequence<AccountsState>
        get() = sequenceOf(
            AccountsState(
                totalBalance = AmountUiModel(
                    value = "-100,000,000",
                    currencySymbol = "$"
                ),
                accounts = buildList {
                    repeat(50) {
                        add(
                            AccountUiModel(
                                id = "1",
                                icon = IconUiModel(
                                    icon = Res.drawable.ic_atom,
                                    tint = Color.Cyan,
                                    backgroundColor = Color.Black
                                ),
                                name = "Hello world",
                                amount = AmountUiModel(
                                    value = "-100,000,000",
                                    currencySymbol = "$"
                                )
                            )
                        )
                    }
                }
            )
        )

}