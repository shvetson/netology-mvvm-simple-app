package ru.shvets.simplemvvm.navigator

import android.app.Application
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import ru.shvets.simplemvvm.MainActivity
import ru.shvets.simplemvvm.views.UiActions
import ru.shvets.simplemvvm.views.screen.base.BaseScreen

class MainNavigator(
    application: Application
) : AndroidViewModel(application), Navigator, UiActions {

    val whenActivityActive = MainActivityActions()

    override fun launch(screen: BaseScreen) = whenActivityActive {

    }

    override fun goBack(result: Any?) = whenActivityActive {
        it.onBackPressed()
    }

    override fun onCleared() {
        super.onCleared()
        whenActivityActive.clear()
    }

    override fun toast(messageRes: Int) {
        Toast.makeText(getApplication(), messageRes, Toast.LENGTH_SHORT).show()
    }

    override fun getString(messageRes: Int): String {
        return getApplication<Application>().getString(messageRes)
    }

    fun launchFragment(activity: MainActivity, screen: BaseScreen, addToBackStack: Boolean = true) {
        val fragment = screen.javaClass.enclosingClass.newInstance() as Fragment
        val transaction = activity.supportFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(null)
    }


}