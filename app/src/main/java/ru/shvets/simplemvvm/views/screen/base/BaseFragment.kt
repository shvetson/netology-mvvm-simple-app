package ru.shvets.simplemvvm.views.screen.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract val viewModel: BaseViewModel
}