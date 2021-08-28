package ru.skillfactory.rentateam.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.skillfactory.rentateam.R
import ru.skillfactory.rentateam.databinding.FragmentListBinding

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private var binding: FragmentListBinding? = null
    private val viewModel by viewModels<ListViewModel>()
    private val adapter by lazy {
        UsersAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.usersListView?.adapter = adapter
        viewModel.getUsers().observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}