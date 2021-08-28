package ru.skillfactory.rentateam.data.source

import io.reactivex.Single
import retrofit2.http.GET
import ru.skillfactory.rentateam.data.dto.UsersResponse

interface UsersApi {

    @GET("users")
    fun getUsers(): Single<UsersResponse>
}