package app.isaruff.budgettracker.libs.core.task

/**
 * Represents a single executable unit of business logic that runs asynchronously.
 *
 * A [Task] encapsulates a use case or operation that performs its work within a coroutine context.
 * It should be side-effect free apart from the intended business action, and must suspend until
 * a result is produced.
 *
 * Typical usage:
 * - Fetching data from a repository or network source.
 * - Executing a domain operation that requires asynchronous IO.
 * */

interface Task<in T, out R> {

    suspend fun execute(params: T): R
}