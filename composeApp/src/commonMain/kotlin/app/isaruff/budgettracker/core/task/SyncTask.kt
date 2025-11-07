package app.isaruff.budgettracker.core.task

/**
 * Represents a synchronous, non-suspending unit of business logic.
 *
 * A [SyncTask] performs immediate, deterministic work without requiring suspension
 * or asynchronous execution. It’s intended for lightweight domain operations such as
 * validation, in-memory transformations, or local computations.
 *
 * Use [SyncTask] when:
 * - The operation completes instantly and doesn’t need coroutine support.
 * - You need to isolate small, reusable pieces of business logic within the domain layer.
 **/
interface SyncTask<in T, out R> {

    fun execute(params: T): R
}