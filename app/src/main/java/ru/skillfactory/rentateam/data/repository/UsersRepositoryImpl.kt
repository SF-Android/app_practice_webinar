package ru.skillfactory.rentateam.data.repository

import io.reactivex.Single
import ru.skillfactory.rentateam.data.source.local.UsersDao
import ru.skillfactory.rentateam.data.source.local.UsersDatabaseMapper
import ru.skillfactory.rentateam.data.source.remote.UsersApi
import ru.skillfactory.rentateam.data.source.remote.dto.UserResponse
import ru.skillfactory.rentateam.data.source.remote.dto.UsersResponse
import ru.skillfactory.rentateam.domain.mapper.UsersMapper
import ru.skillfactory.rentateam.domain.model.User
import ru.skillfactory.rentateam.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl
@Inject constructor(
    private val api: UsersApi,
    private val dao: UsersDao,
    private val mapper: @JvmSuppressWildcards UsersMapper<UsersResponse, UserResponse>,
    private val dbMapper: UsersDatabaseMapper,
) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return api.getUsers()
            .map { mapper.map(it) }
            .doOnSuccess {
                dao.insertUsers(dbMapper.mapToDBEntities(it))
            }
    }
}