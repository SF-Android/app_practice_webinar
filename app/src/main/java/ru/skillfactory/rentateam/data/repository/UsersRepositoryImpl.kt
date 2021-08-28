package ru.skillfactory.rentateam.data.repository

import io.reactivex.Single
import ru.skillfactory.rentateam.data.dto.UserResponse
import ru.skillfactory.rentateam.data.dto.UsersResponse
import ru.skillfactory.rentateam.data.source.UsersApi
import ru.skillfactory.rentateam.domain.mapper.UsersMapper
import ru.skillfactory.rentateam.domain.model.User
import ru.skillfactory.rentateam.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl
@Inject constructor(
    private val api: UsersApi,
    private val mapper: @JvmSuppressWildcards UsersMapper<UsersResponse, UserResponse>,
) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return api.getUsers().map { mapper.map(it) }
    }
}