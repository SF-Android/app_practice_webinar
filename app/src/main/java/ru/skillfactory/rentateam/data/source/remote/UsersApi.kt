package ru.skillfactory.rentateam.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET
import ru.skillfactory.rentateam.data.source.remote.dto.UsersResponse

interface UsersApi {

    @GET("users")
    fun getUsers(): Single<UsersResponse>
}