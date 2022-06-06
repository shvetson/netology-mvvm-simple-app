package ru.shvets.simplemvvm.views.screen.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shvets.simplemvvm.R
import ru.shvets.simplemvvm.navigator.Navigator
import ru.shvets.simplemvvm.views.UiActions
import ru.shvets.simplemvvm.views.screen.base.BaseViewModel
import ru.shvets.simplemvvm.views.screen.edit.EditFragment

class HelloViewModel(
    private val navigator: Navigator,
    private val ui: UiActions,
    screen: HelloFragment.Screen
) : BaseViewModel() {

    private val _currentMessageLiveData = MutableLiveData<String>()
    val currentMessageLivedata: LiveData<String> = _currentMessageLiveData

    init {
        _currentMessageLiveData.value = ui.getString(R.string.hello_world)
    }

    override fun onResult(result: Any) {
        if (result is String) {
            _currentMessageLiveData.value = result
        }
    }

    fun onEditPressed() {
        navigator.launch(EditFragment.Screen(initialValue = currentMessageLivedata.value!!))
    }
}