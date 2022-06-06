package ru.shvets.simplemvvm.navigator

import ru.shvets.simplemvvm.views.screen.base.BaseScreen

interface Navigator {
    fun launch(screen: BaseScreen)
    fun goBack(result: Any? = null)
}