package app.isaruff.budgettracker.core.mvi

/**
 * Marker interface for defining the **complete representation of UI state** in an MVI architecture.
 *
 * A [UiState] captures all immutable data required to render the screen at any moment.
 * It reflects both **domain data** and **UI-specific flags** (e.g., loading, error visibility).
 *
 * The [UiState] must be **pure and serializable**, ensuring predictable recompositions
 * and debuggable state transitions. Any temporary or non-reproducible behavior should
 * be modeled via [SideEffect] instead.
 **/
interface UiState

/**
 * Represents a **stateless** screen or component within the MVI architecture.
 *
 * Used for UI layers that do not expose or depend on any mutable [UiState].
 * Such screens typically render static content, navigation placeholders, or
 * one-off informational views that do not require state observation or updates.
 *
 * This marker can be used to differentiate purely declarative screens from
 * state-driven ones, allowing for simplified ViewModel or composable handling.
 */
data object Stateless : UiState