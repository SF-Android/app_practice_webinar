package ru.skillfactory.rentateam.domain.repository

import io.reactivex.Single
import ru.skillfactory.rentateam.domain.model.User

interface UsersRepository {

    fun getUsers(): Single<List<User>>
}