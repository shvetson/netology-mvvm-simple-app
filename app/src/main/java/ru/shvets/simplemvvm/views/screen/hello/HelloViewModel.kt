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
    screen: HelloFragment.Screen
) : BaseViewModel() {

    private val _currentMessageLiveData = MutableLiveData<String>()
    val currentMessageLiveData: LiveData<String> = _currentMessageLiveData

    init {
        _currentMessageLiveData.value = navigator.getString(R.string.hello_world)
    }

    override fun onResult(result: Any) {
        if (result is String) {
            _currentMessageLiveData.value = result
        }
    }

    fun onEditPressed() {
        navigator.launch(EditFragment.Screen(initialValue = currentMessageLiveData.value!!))
    }
}