package ru.shvets.simplemvvm.views

import androidx.annotation.StringRes

interface UiActions {
    fun toast(@StringRes messageRes: Int)
    fun getString(@StringRes messageRes: Int): String
}