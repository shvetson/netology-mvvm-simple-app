package ru.shvets.simplemvvm.navigator

import androidx.annotation.StringRes
import ru.shvets.simplemvvm.views.screen.base.BaseScreen

interface Navigator {
    fun launch(screen: BaseScreen)
    fun goBack(result: Any? = null)
    fun toast(@StringRes messageRes: Int)
    fun getString(@StringRes messageRes: Int): String
}