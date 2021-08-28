package ru.skillfactory.rentateam.domain.mapper

import ru.skillfactory.rentateam.domain.model.User

interface UsersMapper<in LIST, in USER> {

    fun map(items: LIST): List<User>

    fun map(item: USER): User
}