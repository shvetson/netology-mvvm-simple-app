package ru.shvets.simplemvvm.views.screen.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shvets.simplemvvm.R
import ru.shvets.simplemvvm.views.Event
import ru.shvets.simplemvvm.navigator.Navigator
import ru.shvets.simplemvvm.views.UiActions
import ru.shvets.simplemvvm.views.screen.base.BaseViewModel

class EditViewModel(
    private val navigator: Navigator,
    screen: EditFragment.Screen
) : BaseViewModel() {

    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val initialMessageEvent: LiveData<Event<String>> = _initialMessageEvent

    init {
        // sending initial value from screen argument to the fragment
        _initialMessageEvent.value = Event(screen.initialValue)
    }

    fun onSavePressed(message: String) {
        if (message.isBlank()) {
            navigator.toast(R.string.empty_message)
            return
        }
        navigator.goBack(message)
    }

    fun onCancelPressed() {
        navigator.goBack()
    }

}