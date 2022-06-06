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
    private val ui: UiActions,
    screen: EditFragment.Screen,
) : BaseViewModel() {

    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val initialMessageEvent : LiveData<Event<String>> = _initialMessageEvent

    init {
        _initialMessageEvent.value = Event(screen.initialValue)
    }

    fun onSavePressed(message: String) {
        if (message.isBlank()) {
            ui.toast(R.string.empty_message)
            return
        }
    }

    fun onCancelPressed() {
        navigator.goBack()
    }
}