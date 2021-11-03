package ru.skillfactory.rentateam.data.source.remote

import ru.skillfactory.rentateam.data.source.remote.dto.UserResponse
import ru.skillfactory.rentateam.data.source.remote.dto.UsersResponse
import ru.skillfactory.rentateam.domain.mapper.UsersMapper
import ru.skillfactory.rentateam.domain.model.User
import javax.inject.Inject

class UsersMapperImpl
@Inject constructor(
) : UsersMapper<@JvmSuppressWildcards UsersResponse, @JvmSuppressWildcards UserResponse> {

    override fun map(items: UsersResponse): List<User> {
        return items.users.map {
            map(it)
        }
    }

    override fun map(item: UserResponse): User {
        return with(item) {
            User(
                id,
                firstName,
                lastName,
                "$firstName $lastName",
                email,
                avatarUrl
            )
        }
    }
}