package app.isaruff.budgettracker.libs.core.mvi

/**
 * Marker interface for defining **user-originated inputs** in an MVI architecture.
 *
 * A [UiEvent] represents a concrete user action or intent that triggers state
 * transitions or side effects in the ViewModel. It serves as the **entry point**
 * into the unidirectional data flow.
 *
 * Typical examples include:
 * - Button clicks.
 * - Text input changes.
 * - Screen lifecycle or intent-based triggers (e.g., `OnStart`, `OnResume`).
 **/
interface UiEvent