package ru.shvets.simplemvvm

import android.app.Application
import ru.shvets.simplemvvm.model.RepositoryImpl

class App: Application() {
    val models = listOf(
        RepositoryImpl()
    )
}