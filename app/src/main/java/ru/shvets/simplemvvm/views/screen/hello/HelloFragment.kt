package ru.shvets.simplemvvm.views.screen.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ru.shvets.simplemvvm.databinding.FragmentHelloBinding
import ru.shvets.simplemvvm.views.screen.base.BaseFragment
import ru.shvets.simplemvvm.views.screen.base.BaseScreen
import ru.shvets.simplemvvm.views.screen.base.screenViewModel

class HelloFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<HelloViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentHelloBinding.inflate(inflater, container, false)

        binding.editButton.setOnClickListener { viewModel.onEditPressed() }

        viewModel.currentMessageLiveData.observe(viewLifecycleOwner) {
            binding.valueTextView.text = it
        }

        return binding.root
    }

}