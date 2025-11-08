package app.isaruff.budgettracker.presentation.model

data class AmountUiModel(
    val value: String,
    val currencySymbol: String
) {

    fun formattedAmount() : String {
        return value + currencySymbol
    }

    companion object {
        fun zero(): AmountUiModel = AmountUiModel(
            value = "0.00",
            currencySymbol = ""
        )
    }
}
