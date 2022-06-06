package ru.shvets.simplemvvm.views.screen.base

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.shvets.simplemvvm.navigator.ARG_SCREEN
import ru.shvets.simplemvvm.navigator.MainNavigator
import ru.shvets.simplemvvm.navigator.Navigator
import ru.shvets.simplemvvm.views.screen.base.BaseFragment

/**
 * This view-model factory allows creating view-models which have constructor with 2
 * arguments: [Navigator] and some subclass of [BaseScreen].
 */
class ViewModelFactory(
    private val screen: BaseScreen,
    private val fragment: BaseFragment
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val hostActivity = fragment.requireActivity()
        val application = hostActivity.application
        val navigatorProvider = ViewModelProvider(hostActivity,
            ViewModelProvider.AndroidViewModelFactory(application)
        )
        val navigator = navigatorProvider[MainNavigator::class.java]

        // if you need to create a view model with some other arguments -> you may
        // use 'constructors' field for searching the desired constructor
        val constructor = modelClass.getConstructor(Navigator::class.java, screen::class.java)
        return constructor.newInstance(navigator, screen)
    }

}

/**
 * Use this method for getting view-models from your fragments
 */
inline fun <reified VM : ViewModel> BaseFragment.screenViewModel() = viewModels<VM> {
    val screen = requireArguments().getSerializable(ARG_SCREEN) as BaseScreen
    ViewModelFactory(screen, this)
}