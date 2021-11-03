package ru.skillfactory.rentateam.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.skillfactory.rentateam.R
import ru.skillfactory.rentateam.databinding.FragmentListBinding
import ru.skillfactory.rentateam.domain.model.User
import ru.skillfactory.rentateam.presentation.UiState

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private var binding: FragmentListBinding? = null
    private val viewModel by viewModels<ListViewModel>()
    private val adapter by lazy {
        UsersAdapter(
            onItemClickAction = { openItem(it) }
        )
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
            when (it) {
                is UiState.Success -> { resolveSuccess(it.value) }
                is UiState.Failure -> { resolveFailure(it.exception) }
                is UiState.Loading -> { resolveLoading() }
            }

        }
    }

    private fun resolveSuccess(items: List<User>) {
        adapter.submitList(items)
        binding?.usersListView?.visibility = View.VISIBLE
        binding?.usersProgressView?.visibility = View.GONE
        binding?.usersErrorView?.visibility = View.GONE
    }

    private fun resolveFailure(exception: Throwable?) {
        binding?.usersListView?.visibility = View.GONE
        binding?.usersProgressView?.visibility = View.GONE
        binding?.usersErrorView?.visibility = View.VISIBLE
    }

    private fun resolveLoading() {
        binding?.usersListView?.visibility = View.GONE
        binding?.usersProgressView?.visibility = View.VISIBLE
        binding?.usersErrorView?.visibility = View.GONE
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun openItem(user: User) {
        val action = ListFragmentDirections.actionOpenItem(user)
        findNavController().navigate(action)
    }
}