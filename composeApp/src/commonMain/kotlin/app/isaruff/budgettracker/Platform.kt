package app.isaruff.budgettracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform