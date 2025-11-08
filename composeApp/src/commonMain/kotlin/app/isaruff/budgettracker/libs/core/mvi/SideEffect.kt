package app.isaruff.budgettracker.libs.core.mvi

/**
 * Marker interface for defining **one-time effects** in an MVI architecture.
 *
 * A [SideEffect] represents transient, non-persistent events that occur as a result
 * of user interaction or system state changes, but should **not** be retained as part
 * of the [UiState].
 *
 * Typical examples include:
 * - Navigation events.
 * - Showing a Snackbar, Toast, or Dialog.
 * - Triggering system-level actions (e.g., opening a URL, requesting permission).
 *
 * Each [SideEffect] is **consumed once** by the UI layer and should never
 * reappear after configuration changes or recomposition.
 * */
interface SideEffect

/**
 * Represents a screen or feature that does not produce any [SideEffect].
 *
 * Used as a placeholder implementation for MVI components where
 * one-time or transient events (such as navigation, toasts, or dialogs)
 * are not required.
 *
 * Declaring [NoEffect] allows such screens to remain structurally consistent
 * with the MVI framework while explicitly indicating the absence of side effects.
 */data object NoEffect: SideEffect