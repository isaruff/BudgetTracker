package app.isaruff.budgettracker.core.task

import kotlinx.coroutines.flow.Flow

/**
 * Represents a task that emits a stream of values over time.
 *
 * A [FlowTask] encapsulates business logic that produces a [kotlinx.coroutines.flow.Flow]
 * rather than a single result. It’s ideal for observing data sources, state changes,
 * or continuous updates such as user sessions, balances, or background syncs.
 *
 * Each emission within the returned [Flow] reflects the latest state of the underlying
 * domain operation.
 * */
interface FlowTask<in T, out R> {
    fun buildFlow(params: T): Flow<R>
}