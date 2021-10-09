package ru.skillfactory.rentateam.presentation.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import ru.skillfactory.rentateam.R
import ru.skillfactory.rentateam.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.userName?.text = args.user.full_name
        binding?.userEmail?.text = args.user.email
        Picasso.get()
            .load(args.user.avatarUrl)
            .fit()
            .into(binding?.userIcon)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}