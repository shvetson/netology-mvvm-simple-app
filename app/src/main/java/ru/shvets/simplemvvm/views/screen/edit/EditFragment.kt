package ru.shvets.simplemvvm.views.screen.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.shvets.simplemvvm.databinding.FragmentEditBinding
import ru.shvets.simplemvvm.views.screen.base.BaseFragment
import ru.shvets.simplemvvm.views.screen.base.BaseScreen
import ru.shvets.simplemvvm.views.screen.base.BaseViewModel
import ru.shvets.simplemvvm.views.screen.base.screenViewModel

class EditFragment : BaseFragment() {
    class Screen(
        val initialValue: String
    ) : BaseScreen

    override val viewModel by screenViewModel<EditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEditBinding.inflate(inflater, container, false)

        binding.saveButton.setOnClickListener{
            viewModel.onSavePressed(binding.valueEditText.toString())
        }

        binding.cancelButton.setOnClickListener {
            viewModel.onCancelPressed()
        }

        viewModel.initialMessageEvent.observe(viewLifecycleOwner) {
            it.getValue()?.let { message -> binding.valueEditText.setText(message) }
        }

        return binding.root
    }
}