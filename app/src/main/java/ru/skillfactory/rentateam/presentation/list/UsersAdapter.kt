package ru.skillfactory.rentateam.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.skillfactory.rentateam.databinding.UserItemBinding
import ru.skillfactory.rentateam.domain.model.User
import ru.skillfactory.rentateam.presentation.list.UsersAdapter.UserViewHolder

class UsersAdapter : ListAdapter<User, UserViewHolder>(UsersDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class UserViewHolder(
        val binding: UserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.userItemName.text = user.full_name
            binding.userItemEmail.text = user.email
            Picasso.get()
                .load(user.avatarUrl)
                .fit()
                .into(binding.userItemIcon)
        }
    }
}