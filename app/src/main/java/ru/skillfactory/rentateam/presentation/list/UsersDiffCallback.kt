package ru.skillfactory.rentateam.presentation.list

import androidx.recyclerview.widget.DiffUtil
import ru.skillfactory.rentateam.domain.model.User

object UsersDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}