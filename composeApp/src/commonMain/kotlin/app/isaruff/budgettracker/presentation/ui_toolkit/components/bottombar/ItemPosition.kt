package app.isaruff.budgettracker.presentation.ui_toolkit.components.bottombar

enum class ItemPosition {
    Single,
    Start,
    Middle,
    End;

    companion object {
        fun <T> List<T>.getPosition(index: Int): ItemPosition {
            if (size == 1) return Single
            return when (index) {
                0 -> Start
                size - 1 -> End
                else -> Middle
            }
        }
    }
}